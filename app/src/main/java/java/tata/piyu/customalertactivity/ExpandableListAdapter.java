package java.tata.piyu.customalertactivity;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context _context;
    private List<String> _listDataHeader;
    HashMap<String,List<String>> _listDataChild;
    public ExpandableListAdapter(ExpandedListViewActivity expandedListViewActivity, List<String> listDataHeader, HashMap<String,List<String>> listDataChild) {

        this._context=expandedListViewActivity;
        this._listDataChild=listDataChild;
        this._listDataHeader=listDataHeader;
    }

    @Override
    public int getGroupCount() { return this._listDataHeader.size(); }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPostion) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPostion);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       String headerTitle= (String) getGroup(groupPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_group,null);
        }
        TextView textView=convertView.findViewById(R.id.lblListHeader);
        textView.setTypeface(null,Typeface.BOLD);
        textView.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        final String childText =(String) getChild(groupPosition,childPosition);
        if(convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.list_view,null);
        }
        TextView textView=convertView.findViewById(R.id.lblListener);
        textView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPostition, int childPositio) {
        return true;
    }
}
