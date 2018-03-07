package com.example.admin.demo.list.pinned_section_listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.demo.R;
import com.example.admin.demo.list.pinned_section_listview.adapter.MyRecyclerAdapter;
import com.example.admin.demo.list.pinned_section_listview.entity.Item;
import com.example.admin.demo.list.pinned_section_listview.entity.LawClassEntity;
import com.example.admin.demo.list.pinned_section_listview.entity.NameBean;
import com.example.admin.demo.list.pinned_section_listview.view.SectionDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/12.
 * 固定分组考经滚动
 */

public class PinnerSectionListviewActivity extends Activity {
    private  List<Item>list;
    private RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;
    private List<NameBean>dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pinner_section_listview_activity);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        list=innnerData();
        setPullAction(list);
        adapter=new MyRecyclerAdapter(list,this,getLayoutInflater());
        recyclerView.addItemDecoration(new SectionDecoration(dataList,this, new SectionDecoration.DecorationCallback() {
            //返回标记id (即每一项对应的标志性的字符串)
            @Override
            public String getGroupId(int position) {
                if(dataList.get(position).getName()!=null) {
                    return dataList.get(position).getName();
                }
                return "-1";
            }

            //获取同组中的第一个内容
            @Override
            public String getGroupFirstLine(int position) {
                if(dataList.get(position).getName()!=null) {
                    return dataList.get(position).getName();
                }
                return "";
            }
        }));
        recyclerView.setAdapter(adapter);

    }

    public List<Item> innnerData() {
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(0,new LawClassEntity("348", "法律级次", "346", "1"),0,0));
        list.add(new Item(1,new LawClassEntity("354", "法律", "348", "0"),0,1));
        list.add(new Item(1,new LawClassEntity("355", "行政法规", "348", "0"),0,2));
        list.add(new Item(1,new LawClassEntity("356", "部门规章", "348", "0"),0,3));
        list.add(new Item(1,new LawClassEntity("357", "规范性文件", "348", "0"),0,4));
        list.add(new Item(1,new LawClassEntity("358", "税收协定", "348", "0"),0,5));
        //====================================================
        list.add(new Item(0,new LawClassEntity("349", "税种类别", "346", "1"),1,6));
        list.add(new Item(1,new LawClassEntity("359", "增值税", "349", "0"),1,7));
        list.add(new Item(1,new LawClassEntity("360", "消费税", "349", "0"),1,8));
        list.add(new Item(1,new LawClassEntity("361", "营业税", "349", "0"),1,9));
        list.add(new Item(1,new LawClassEntity("362", "企业所得税", "349", "0"),1,10));
        list.add(new Item(1,new LawClassEntity("363", "个人所得税", "349", "0"),1,11));
        list.add(new Item(1,new LawClassEntity("364", "资源税", "349", "0"),1,12));
        list.add(new Item(1,new LawClassEntity("365", "城市维护建设税", "349", "0"),1,13));
        list.add(new Item(1,new LawClassEntity("366", "房产税", "349", "0"),1,14));
        list.add(new Item(1,new LawClassEntity("367", "印花税", "349", "0"),1,15));
        list.add(new Item(1,new LawClassEntity("368", "城镇土使用税", "349", "0"),1,16));
        list.add(new Item(1,new LawClassEntity("369", "土地增值税", "349", "0"),1,17));
        list.add(new Item(1,new LawClassEntity("370", "车船税", "349", "0"),1,18));
        list.add(new Item(1,new LawClassEntity("371", "车辆购置税", "349", "0"),1,19));
        list.add(new Item(1,new LawClassEntity("372", "烟叶税", "349", "0"),1,20));
        list.add(new Item(1,new LawClassEntity("374", "耕地占用税", "349", "0"),1,21));
        list.add(new Item(1,new LawClassEntity("375", "契税", "349", "0"),1,22));
        list.add(new Item(1,new LawClassEntity("377", "进出口税", "349", "0"),1,23));
        list.add(new Item(1,new LawClassEntity("378", "有关规税", "349", "0"),1,24));
        //=====================================================
        list.add(new Item(0,new LawClassEntity("350", "税收优惠", "346", "1"),2,25));
        list.add(new Item(1,new LawClassEntity("379", "就业再就业", "350", "0"),2,26));
        list.add(new Item(1,new LawClassEntity("380", "高新技术、软件开发、集成电路产业", "350", "0"),2,27));
        list.add(new Item(1,new LawClassEntity("381", "农副产品加工业和农业产业化", "350", "0"),2,28));
        list.add(new Item(1,new LawClassEntity("382", "节能减排和环境保护", "350", "0"),2,29));
        list.add(new Item(1,new LawClassEntity("383", "金融保险证券", "350", "0"),2,30));
        list.add(new Item(1,new LawClassEntity("384", "文教卫生体育", "350", "0"),2,31));
        list.add(new Item(1,new LawClassEntity("385", "民政福利与灾害减免", "350", "0"),2,32));
        list.add(new Item(1,new LawClassEntity("386", "区域经济发展优惠", "350", "0"),2,33));
        list.add(new Item(1,new LawClassEntity("387", "其他税收优惠", "350", "0"),2,34));
        //========================================================
        list.add(new Item(0,new LawClassEntity("351", "征收管理", "346", "1"),3,35));
        list.add(new Item(1,new LawClassEntity("394", "税务登记", "351", "0"),3,36));
        list.add(new Item(1,new LawClassEntity("395", "账簿凭证管理", "351", "0"),3,37));
        list.add(new Item(1,new LawClassEntity("396", "纳税申报", "351", "0"),3,38));
        list.add(new Item(1,new LawClassEntity("397", "税款征收", "351", "0"),3,39));
        list.add(new Item(1,new LawClassEntity("398", "增值税专用发票管理", "351", "0"),3,40));
        list.add(new Item(1,new LawClassEntity("399", "普通发票管理", "351", "0"),3,41));
        list.add(new Item(1,new LawClassEntity("400", "税务检查", "351", "0"),3,42));
        list.add(new Item(1,new LawClassEntity("401", "税务代理", "351", "0"),3,43));
        //======================================================
        list.add(new Item(0,new LawClassEntity("353", "适用对象", "346", "1"),4,44));
        list.add(new Item(1,new LawClassEntity("388", "个人", "353", "0"),4,45));
        list.add(new Item(1,new LawClassEntity("389", "企业", "353", "0"),4,46));
        //======================================================
        list.add(new Item(0,new LawClassEntity("390", "法律救济", "346", "1"),5,47));
        list.add(new Item(1,new LawClassEntity("402", "税务行政诉讼", "390", "0"),5,48));
        list.add(new Item(1,new LawClassEntity("403", "税务行政赔偿", "390", "0"),5,49));
        return list;
    }
    private void setPullAction(List<Item> comingslist) {
        dataList = new ArrayList<>();

        for (int i = 0; i < comingslist.size(); i++) {
            NameBean nameBean = new NameBean();
            String name0 = comingslist.get(i).getSectionPosition()+"";
            nameBean.setName(name0);
            dataList.add(nameBean);
        }
    }

}
