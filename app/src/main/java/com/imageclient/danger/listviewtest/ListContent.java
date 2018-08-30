package com.imageclient.danger.listviewtest;

public class ListContent
{
    private int Num = 0;
    private String Title = "";
    private String Content = "";

    public ListContent(int num, String title, String content
    ) {
        Num = num;
        Title = title;
        Content = content;
    }

    public int getNum() {
        return Num;
    }
    public void setNum(int num) {
        Num = num;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getContent() {
        return Content;
    }
    public void setContent(String content) {
        Content = content;
    }
}
