package scoutapp.com.br.scoutapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.model.Athlete;

/**
 * Created by HenriqueKoga on 31/05/16.
 */
public class ScoutAdapter extends BaseAdapter {

    private final List<Athlete> athletes;
    private final Context context;

    public ScoutAdapter(Context context, List<Athlete> athletes) {
        this.context = context;
        this.athletes = athletes;
    }

    @Override
    public int getCount() {
        return athletes.size();
    }

    @Override
    public Object getItem(int position) {
        return athletes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return athletes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Athlete athlete = athletes.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, null);

        TextView fieldName = (TextView) view.findViewById(R.id.item_name);
        fieldName.setText(athlete.getName());


        return view;
    }
}