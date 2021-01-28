package com.alliah;

public class TextBox extends UIControl {
    private  String text = ""; // Field

//    public TextBox() {
//        super(true);
//        System.out.println("Text box");
//    }


    @Override
    public void render() {
        System.out.println("A TextBox");
    }

    @Override
    public String toString(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }
    public void clear(){
        text = "";
    }

}
