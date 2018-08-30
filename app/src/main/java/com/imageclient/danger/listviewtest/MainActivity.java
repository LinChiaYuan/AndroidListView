package com.imageclient.danger.listviewtest;
/**
 *
 *  author  :   Chia Yuan Lin (林家源)
 *
 *  email   :   lo919201@gmail.com
 *
 * **/
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{
    ListView mListView;
    List<ListContent> mListContent;
    private listViewAdapter mlistViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListContent = new ArrayList<>();
        for(int i =0 ; i<50;i++)
        {
            mListContent.add(new ListContent(i+1,"這是第" + (i+1) + "科", (int)(Math.random()*100+1) + " "));
        }

        mListView = (ListView) findViewById(R.id.listview);
        mListView.setOnItemClickListener(this);
        mlistViewAdapter = new listViewAdapter(this);
        mListView.setAdapter(mlistViewAdapter);
    }

    @Override
    public void onItemClick(AdapterView adapterView, View view, int i, long l)
    {
        Toast toast = Toast.makeText(MainActivity.this,mListContent.get(i).getContent(), Toast.LENGTH_LONG);
        toast.show();
    }

    private class listViewAdapter extends BaseAdapter
    {
        private LayoutInflater inflater;
        private TextView TxtNum, TxtTitle, TxtContent;

        public listViewAdapter(Context context)
        {
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount()
        {
            if(mListContent != null)
                return mListContent.size();
            else
                return 0;
        }
        @Override
        public Object getItem(int i)
        {
            return mListContent.get(i);
        }
        @Override
        public long getItemId(int i)
        {
            return i;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            view = inflater.inflate(R.layout.listview_content, null);

            TxtNum = (TextView) view.findViewById(R.id.txt_num);
            TxtNum.setText("" + mListContent.get(i).getNum());

            TxtTitle = (TextView) view.findViewById(R.id.txt_title);
            TxtTitle.setText(mListContent.get(i).getTitle());

            TxtContent = (TextView) view.findViewById(R.id.txt_content);
            TxtContent.setText(mListContent.get(i).getContent());
            return view;
        }
    }
}
