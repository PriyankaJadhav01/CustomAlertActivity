package java.tata.piyu.customalertactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandedListViewActivity extends AppCompatActivity {
 ExpandableListView expandableListView;
 List<String> listDataHeader;
 HashMap<String,List<String>> listDataChild;
 ExpandableListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_list_view);
        expandableListView=findViewById(R.id.lvExp);
        prepareListData();
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listDataChild);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String,List<String>>();

        listDataHeader.add("Topics");
        listDataHeader.add("Topics Covered");
        listDataHeader.add("Topics Not Covered");
        listDataHeader.add("Switch to StartActivity For Result");

        List<String> top250 =new ArrayList<>();
        top250.add("A");
        top250.add("B");
        top250.add("C");
        top250.add("D");
        top250.add("E");
        top250.add("F");
        top250.add("G");
        top250.add("H");
        top250.add("I");
        top250.add("J");
        top250.add("K");
        top250.add("L");
        top250.add("M");
        top250.add("N");
        top250.add("O");
        top250.add("P");
        top250.add("Q");
        top250.add("R");
        top250.add("S");
        top250.add("T");
        top250.add("U");
        top250.add("V");
        top250.add("W");
        top250.add("X");
        top250.add("Y");
        top250.add("Z");

        List<String> nowShowing=new ArrayList<String>();
        nowShowing.add("Android");
        nowShowing.add("Android Arch");
        nowShowing.add("Android SDK");
        nowShowing.add("Android UI");
        nowShowing.add("Android Notification");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Android Maps");
        comingSoon.add("Android Bluetooth");
        comingSoon.add("Android WIFI");
        List<String> workon=new ArrayList<String>();
        workon.add("Start Activity and Start Activity Result");
        listDataChild.put(listDataHeader.get(0),top250);
        listDataChild.put(listDataHeader.get(1),nowShowing);
        listDataChild.put(listDataHeader.get(2),comingSoon);
        listDataChild.put(listDataHeader.get(3),workon);

    }
}
