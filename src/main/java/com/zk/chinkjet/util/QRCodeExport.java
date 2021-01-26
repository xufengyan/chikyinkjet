package com.zk.chinkjet.util;

import com.google.zxing.*;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

/**
 * @author xf
 * @version 1.0
 * @date 2021/1/5 10:47
 */
public class QRCodeExport {
    private static final int BLACK = 0xff000000;
    private static final int WHITE = 0xFFFFFFFF;
    /**
     *
     * @param content 生产内容
     * @param basePath 保存地址
     * @return
     */
    public static String createQRCode(String content,String basePath,String type){
        QRCodeExport qrCodeExport = new QRCodeExport();
        basePath = basePath + "QRCode/"+DateFormat.getNowDate()+"/";
        File file = new File(basePath);
        if (!file.exists()){
            file.mkdirs();
        }
        basePath = basePath+ UUID.randomUUID().toString().replace("-", "")+".bmp";
        BarcodeFormat format = null;
        switch (type) {
            case "EAN8":
                format = BarcodeFormat.EAN_8;
              break;
            case "EAN13":
                format = BarcodeFormat.EAN_13;
              break;
            case "UPCA":
                format = BarcodeFormat.UPC_A;
              break;
            case "QRCODE":  //这里是二维码
                format = BarcodeFormat.QR_CODE;
              break;
            case "CODE39":
                format = BarcodeFormat.CODE_39;
              break;
            case "CODE128":  //这个可以生成
                format = BarcodeFormat.CODE_128;
              break;
            case "ITF":
                format = BarcodeFormat.ITF;
              break;
            case "PDF_417":  //这个可以生成
                format = BarcodeFormat.PDF_417;
              break;
            case "CODABAR":
                format = BarcodeFormat.CODABAR;
              break;
            default:
              throw new IllegalArgumentException("No encoder available for format " + format);
          }

        qrCodeExport.encode(content,new File(basePath), format, 150, 150, null);
        qrCodeExport.decode(file);
        return basePath;
    }



    /**
     * 生成QRCode二维码<br>
     * 在编码时需要将com.google.zxing.qrcode.encoder.Encoder.java中的<br>
     *  static final String DEFAULT_BYTE_MODE_ENCODING = "ISO8859-1";<br>
     *  修改为UTF-8，否则中文编译后解析不了<br>
     */
    public void encode(String contents, File file, BarcodeFormat format, int width, int height, Map<EncodeHintType, ?> hints) {
        try {
            //消除乱码
            contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents, format, width, height);
            writeToFile(bitMatrix, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 生成二维码图片<br>
     *
     * @param matrix
     * @param format
     *            图片格式
     * @param file
     *            生成二维码图片位置
     * @throws IOException
     */
    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        ImageIO.write(image, format, file);
    }

    /**
     * 生成二维码内容<br>
     *
     * @param matrix
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        matrix = deleteWhite(matrix);//删除白边
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
            }
        }
        return image;
    }

    //删除白边
    private static BitMatrix deleteWhite(BitMatrix matrix) {
        int[] rec = matrix.getEnclosingRectangle();
        int resWidth = rec[2] + 1;
        int resHeight = rec[3] + 1;

        BitMatrix resMatrix = new BitMatrix(resWidth, resHeight);
        resMatrix.clear();
        for (int i = 0; i < resWidth; i++) {
            for (int j = 0; j < resHeight; j++) {
                if (matrix.get(i + rec[0], j + rec[1]))
                    resMatrix.set(i, j);
            }
        }
        return resMatrix;
    }
    /**
     * 解析QRCode二维码
     */
    @SuppressWarnings("unchecked")
    public void decode(File file) {
        try {
            BufferedImage image;
            try {
                image = ImageIO.read(file);
                if (image == null) {
                    System.out.println("Could not decode image");
                }
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Result result;
                @SuppressWarnings("rawtypes")
                Hashtable hints = new Hashtable();
                //解码设置编码方式为：utf-8
                hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
                result = new MultiFormatReader().decode(bitmap, hints);
                String resultStr = result.getText();
                System.out.println("解析后内容：" + resultStr);
            } catch (IOException ioe) {
                System.out.println(ioe.toString());
            } catch (ReaderException re) {
                System.out.println(re.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
