package com.zk.chinkjet.controller.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author xf
 * @version 1.0
 * @date 2020/12/18 15:27
 */
public class imageTest3 {
    public void binaryImage() throws IOException {
        File file = new File("D:\\\\home/image/3.jpg");
        BufferedImage image = ImageIO.read(file);

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for(int i= 0 ; i < width ; i++){
            for(int j = 0 ; j < height; j++){
                int rgb = image.getRGB(i, j);
                grayImage.setRGB(i, j, rgb);
            }
        }

        File newFile = new File("D:\\\\home/image/new3.bmp");
        ImageIO.write(grayImage, "bmp", newFile);
    }

//    public void grayImage() throws IOException{
//        File file = new File("D:\\\\home/image/3.jpg");
//        BufferedImage image = ImageIO.read(file);
//
//        int width = image.getWidth();
//        int height = image.getHeight();
//
//        BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
//        for(int i= 0 ; i < width ; i++){
//            for(int j = 0 ; j < height; j++){
//                int rgb = image.getRGB(i, j);
//                grayImage.setRGB(i, j, rgb);
//            }
//        }
//
//        File newFile = new File("D:\\\\home/image/32.jpg");
//        ImageIO.write(grayImage, "jpg", newFile);
//    }


    public void setLucency() throws IOException {
        BufferedImage image = ImageIO.read(new File("D:\\\\home/image/new4.bmp"));
        // 高度和宽度
        int height = image.getHeight();
        int width = image.getWidth();

        // 生产背景透明和内容透明的图片
        ImageIcon imageIcon = new ImageIcon(image);
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics(); // 获取画笔
        g2D.drawImage(imageIcon.getImage(), 0, 0, null); // 绘制Image的图片

        int alpha = 0; // 图片透明度
        // 外层遍历是Y轴的像素
        for (int y = bufferedImage.getMinY(); y < bufferedImage.getHeight(); y++) {
            // 内层遍历是X轴的像素
            for (int x = bufferedImage.getMinX(); x < bufferedImage.getWidth(); x++) {
                int rgb = bufferedImage.getRGB(x, y);
                // 对当前颜色判断是否在指定区间内
                if (colorInRange(rgb)) {
                    alpha = 0;
                } else {
                    // 设置为不透明
                    alpha = 255;
                }
                // #AARRGGBB 最前两位为透明度
                rgb = (alpha << 24) | (rgb & 0x00ffffff);
                bufferedImage.setRGB(x, y, rgb);
            }
        }
        // 绘制设置了RGB的新图片
        g2D.drawImage(bufferedImage, 0, 0, null);

        // 生成图片为PNG
        ImageIO.write(bufferedImage, "png", new File("D:\\\\home/image/new44.bmp"));

}

    // 判断是背景还是内容
    public static boolean colorInRange(int color) {
        int red = (color & 0xff0000) >> 16;// 获取color(RGB)中R位
        int green = (color & 0x00ff00) >> 8;// 获取color(RGB)中G位
        int blue = (color & 0x0000ff);// 获取color(RGB)中B位
        // 通过RGB三分量来判断当前颜色是否在指定的颜色区间内
        if (red >= color_range && green >= color_range && blue >= color_range) {
            return true;
        }
        ;
        return false;
    }

    // 色差范围0~255
    public static int color_range = 210;
    public static void main(String[] args) throws IOException {
//        imageTest3 demo = new imageTest3();
//        demo.binaryImage();
//                imageTest3 demo = new imageTest3();
//        demo.dd();
//        demo.grayImage();
    }
}
