// var drag = document.body.onload = function(){
//     return function () {
//Apply some basic styles
        var css = ".draggable{cursor: move;display: inline-flex;position: absolute;font-size:20px} .text:focus{cursor: auto;} .text-wrapper{width: 100%;position: relative;} .wrap{position: absolute;margin: auto;top: 0;bottom: 0;left: 0;right: 0;}';";
        var style = document.createElement('style');
        if (style.styleSheet) {
            style.styleSheet.cssText = css;
        } else {
            style.appendChild(document.createTextNode(css));
        }
        document.getElementsByTagName('head')[0].appendChild(style);
        console.log("done");

        // Select all elements with the 'draggable' class and stores them in the 'elements' variable
        // 选择所有带有“draggable”类的元素，并将它们存储在“elements”变量中
        var elements = document.querySelectorAll(".draggable");

        // Creates an additional array of all text elements
        var texts = document.querySelectorAll(".text");

        // Variable to store z index of last moved element
        z = 1;

        // Variable to store if you are currently editing text
        editing = false;

        // Stores the last edited text element
        var editedText;

        // Stores the last edited element
        var tgt;

        var clickTimer = null;

        // Adds the mousedown listener on the body element, to listen for when you click away from an element
        document.body.addEventListener('mousedown', cancel);
        document.body.addEventListener('touchstart', cancel);

        // Stops editing text when you click away from it
        function cancel(evt){
            // If the element clicked on is not text
            if(!event.target.classList.contains("text")){
                editing = false;
                // Else, exit out of the edited text
                if(editing){
                    editedText.blur();
                }
            }
        }

        // Adds event listeners to every element that has the draggable class
        // 向具有draggable类的每个元素添加事件监听器
        for(var i = 0; i < elements.length; i++){
            elements[i].addEventListener('mousedown', drag);
            elements[i].addEventListener('touchstart', handleTouch);
            b = elements[i].getBoundingClientRect();
            // Calculate the initial offset of the element from the top left of the page and stores it as a property of the element
            // 计算元素从页面左上角开始的初始偏移量，并将其存储为元素的属性
            elements[i].initialOffsetX = b.left + window.scrollX;
            elements[i].initialOffsetY = b.top + window.scrollY;
            elements[i].x = b.left;
            elements[i].y = b.top;
            elements[i].style.cursor = "move";
            document.addEventListener('mouseup', end);
            document.addEventListener('touchend', end);
        };

        // Adds a mouse event for a doubleclick on the text element and wraps text element in divs
        // 为文本元素上的双击添加鼠标事件，并将文本元素包装在div中
        for(let i = 0; i < texts.length; i++){
            texts[i].addEventListener("dblclick", editText);
            var div = document.createElement("div");
            div.className = "text-wrapper";
            var parent = texts[i].parentNode;
            parent.insertBefore(div,texts[i]);
            div.appendChild(texts[i]);
            div.style.height = outerHeight(texts[i])+"px";
            var div = document.createElement("div");
            div.className = "wrap";
            var parent = texts[i].parentNode;
            parent.insertBefore(div,texts[i]);
            div.appendChild(texts[i]);
            // Lets you edit text
            texts[i].contentEditable = "true";
        }

        // Focuses on the text element
        // 重点关注文本元素
        function editText(evt){
            editedText = evt.target;
            editing = true;
            editedText.focus();
        }
        function handleTouch(evt){
            evt.preventDefault();
            drag(evt);
            if (clickTimer == null) {
                clickTimer = setTimeout(function () {
                    clickTimer = null;
                }, 500)
            } else {
                clearTimeout(clickTimer);
                clickTimer = null;
                editText(evt);
            }
        }

        // Main logic, called when the mouse is clicked
        // 主逻辑，在单击鼠标时调用
        var pitchEvent = null;
        var pitchEventObj = {'dragDiv0':{'fontsize':20,'letterSpacing':0,'rotate':0,'dragX':0,'dragY':0,'historyType':false,'x':0,'y':0}};
        function drag(event) {
            console.log(event.target.style)
            console.log();
            console.log("点击了")
            pitchEvent = event;
            window.parent.pitchEvent = event;
            getStyle();
            // If the targeted element is not text
            // 如果目标元素不是文本
            if(!event.target.classList.contains("text")){
                // Set editing to false and lose focus on the text field
                // 将编辑设置为false并在文本字段上失去焦点
                editing = false;
                if(editing){
                    editedText.blur();
                }
            }

            // If you are not clicking on a text element that is currently being edited
            // 如果您没有单击当前正在编辑的文本元素
            if(!editing){
                console.log("拖拽开始")
                console.log(event)
                // Prevent default behavior and increase z index to bring the new element to the front
                // 防止默认行为，增加z索引，把新元素放在前面
                event.preventDefault();
                moving = true;
                z = z+1;

                // Identify which element was clicked and store in the 'tgt' element, then get position properties of it
                // 标识被单击的元素并存储在“tgt”元素中，然后获取它的位置属性

                tgt = event.target;
                //tgt = event.path[1]
                tgt.attributeName = 'test';
                b = tgt.getBoundingClientRect()
                // var navdome1 = document.getElementById("navdome");
                // console.log(b.left+navdome1.scrollTop+","+b.top+navdome1.scrollLeft);
                var x = b.left + window.scrollX;
                var y = b.top + window.scrollY;
                // var x = b.left+navdome1.scrollTop;
                // var y = b.top+navdome1.scrollLeft;
                //var x = 16
                //var y = 14
                console.log("b.left="+b.left+",b.top="+b.top)
                console.log("window.scrollX="+window.scrollX+",window.scrollY="+window.scrollY)

                console.log(""+x+","+y)
                offsetX = event.pageX || event.changedTouches[0].pageX;
                offsetY = event.pageY || event.changedTouches[0].pageY;
                //offsetX = 61
                //offsetY = 27
                console.log("pagex="+offsetX+",pagey"+offsetY)
                document.addEventListener('mousemove',function(e) {
                    // If the page has been clicked and an element is being dragged
                    if(moving === true){
                        // Calculate the new position of the element, relative to the top left of the page
                        var dx = e.pageX - offsetX + x - tgt.initialOffsetX;
                        var dy = e.pageY - offsetY + y - tgt.initialOffsetY;
                        console.log(e.pageX+","+e.pageY)
                        // Apply the styles to the element
                        var position = 'transform: translate('+dx+'px, '+dy+'px);z-index:'+z+';';
                        tgt.setAttribute('style', position);
                        // console.log('mousemove')
                    };
                });
                document.addEventListener('touchmove',function(e) {
                    var touches = e.changedTouches;
                    // If the page has been clicked and an element is being dragged
                    if(moving === true){
                        for(let i = 0; i < touches.length; i++){
                            // Calculate the new position of the element, relative to the top left of the page
                            var dx = touches[i].pageX - offsetX + x - tgt.initialOffsetX + 0.45376*pitchEventObj[tgt.id].rotate;
                            var dy = touches[i].pageY - offsetY + y - tgt.initialOffsetY ;
                            // console.log("tgt.initialOffsetX"+tgt.initialOffsetX+",initialOffsetY"+tgt.initialOffsetY)
                            // var dx = touches[i].pageX - offsetX + x ;
                            // var dy = touches[i].pageY - offsetY + y ;
                            // console.log(offsetX+","+offsetY+"------"+x+","+y)

                            // Apply the styles to the element
                            // var position = 'transform: translate('+dx+'px, '+dy+'px);z-index:'+z+';';
                            // var position = 'transform: translate('+dx+'px, '+dy+'px) rotate(60deg);z-index:'+z+';';
                            // tgt.style.transform = 'translate('+dx+'px,'+dy+'px) rotate(20deg)';
                            console.log("dx="+dx+",dy="+dy+",offsetX="+offsetX+",offsetY="+offsetY+",x="+x+",y="+y);

                            tgt.style.transform = 'translate('+dx+'px,'+dy+'px) rotate('+pitchEventObj[tgt.id].rotate+'deg)';
                            tgt.style.zIndex = z;

                            // tgt.style.transform = 'rotate(60deg)';

                            // tgt.setAttribute('style', position);

                            // console.log('touchmove')
                            // e.target.attributeName = 'test';
                            var bb = e.target.getBoundingClientRect();
                            var xxxx = bb.left + window.scrollX;
                            var yyyy = bb.top + window.scrollY;
                            console.log(tgt.id);
                            pitchEventObj[tgt.id].dragX = parseFloat(dx).toFixed(5);
                            pitchEventObj[tgt.id].dragY = parseFloat(dy).toFixed(5);
                            pitchEventObj[tgt.id].x = parseFloat(xxxx).toFixed(5) ;
                            pitchEventObj[tgt.id].y = parseFloat(yyyy).toFixed(5);
                            console.log("xxxx="+xxxx+"=====yyyy="+yyyy)
                            console.log(pitchEventObj);

                        }
                    };
                });
            }
        };

        function end(evt) {
            console.log(evt)
            // When the mouse is lifted up, set moving to false
            moving = false;
        };

        function outerHeight(el) {
            var height = el.offsetHeight;
            var style = getComputedStyle(el);

            height += parseInt(style.marginTop) + parseInt(style.marginBottom);
            return height;
        }
        var num = 1;
        //创建文本拖拽
        function createText() {
            //创建element节点
            var newDrag = document.createElement("div")
            newDrag.className = "draggable";
            newDrag.id = "dragDiv"+num;
            newDrag.innerHTML = "测试";
            //设置字体大小
            newDrag.style.fontSize=20+"px"
            newDrag.style.letterSpacing = 0+"em"
            newDrag.style.transform = 'rotate(20deg)'
            newDrag.style.transformOrigin = "0 0"
            //设置字体之间的间距
            // newDrag.style.letterSpacing=10+"px";
            // 设置字体旋转角度
            // newDrag.style.transform = "rotate(50deg)";

            //获取到存放的div的元素
            var nav = document.getElementById("navdome")
            //将创建的div追加进去
            nav.appendChild(newDrag);
            //给新增的div添加事件
            newDrag.addEventListener('mousedown', drag);
            newDrag.addEventListener('touchstart', handleTouch);
            b = newDrag.getBoundingClientRect();
            // // Calculate the initial offset of the element from the top left of the page and stores it as a property of the element
            // // 计算元素从页面左上角开始的初始偏移量，并将其存储为元素的属性
            newDrag.initialOffsetX = b.left + window.scrollX;
            newDrag.initialOffsetY = b.top + window.scrollY;
            newDrag.x = b.left;
            newDrag.y = b.top;
            newDrag.style.cursor = "move";

            // addIncident(newDrag)


            pitchEventObj["dragDiv"+num] = {'id':'dragDiv'+num,'fontsize':20,'letterSpacing':0,'rotate':0,'dragX':0,'dragY':0,'historyType':false,'x':0,'y':0};

            num++;
        }

        function addIncident(event) {
            //给新增的div添加事件

            b = event.getBoundingClientRect();
            // Calculate the initial offset of the element from the top left of the page and stores it as a property of the element
            // 计算元素从页面左上角开始的初始偏移量，并将其存储为元素的属性
            event.initialOffsetX = b.left + window.scrollX;
            event.initialOffsetY = b.top + window.scrollY;
            event.x = b.left;
            event.y = b.top;
            event.style.cursor = "move";

        }

        function getStyle() {
            var localName = pitchEvent.target.localName;
            var atPseentStyle = pitchEvent.target.style;
            var id = atPseentStyle.id;
            var fontSize = atPseentStyle.fontSize;
            switch (localName) {
                case "div":
                    getTxtStyle();
                    break;
                case "img":
                    break;

            }
        }

        function setStyle() {
            if(pitchEvent!=null){
                var atPseentStyle = pitchEvent.target.style;
                atPseentStyle.fontSize = 40+'px';
            }else {
                alert("请选中需要设置的内容")
            }
        }

        // function getTxtStyle() {
        //     var atPseentStyle = pitchEvent.target.style;
        //
        //     window.opener.document.getElementById("testVal").val(pitchEvent.target.innerText);
        //     window.opener.document.getElementById("fontSize").val(atPseentStyle.fontSize.replace("px",""))
        //     window.opener.document.getElementById("letterSpacing").val(atPseentStyle.letterSpacing.replace("em","")*10)
        //
        //     // $("#testVal").val(pitchEvent.target.innerText);
        //     // $("#fontSize").val(atPseentStyle.fontSize.replace("px",""));
        //     // $("#letterSpacing").val(atPseentStyle.letterSpacing.replace("em","")*10)
        // }

//     }
// }

// console.log();
