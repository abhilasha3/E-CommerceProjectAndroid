package adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommercenew.DataModel;
import com.example.ecommercenew.MainActivity;
import com.example.ecommercenew.R;

import java.util.ArrayList;
import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List mValues;
    Context mContext;
  //  protected ItemListener mListener;

    public RecyclerViewAdapter(List<DataModel> values) {

        mValues = values;
        //mContext = context;
        //mListener = itemListener;
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
      //  public ImageView imageView;
        public RelativeLayout relativeLayout;
        DataModel item;

        public ViewHolder(View v) {

            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
            // = (ImageView) v.findViewById(R.id.imageView);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.relativeLayout);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,"Hello",Toast.LENGTH_LONG).show();
                }
            });


        }

         public void bind(DataModel item){
             this.item = item;

             textView.setText(item.text);
            // imageView.setImageResource(item.drawable);
             relativeLayout.setBackgroundColor(Color.parseColor(item.color));
         }


        }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
      //  ViewHolder.setData(mValues.get(i));
        ((ViewHolder) viewHolder).bind((DataModel) mValues.get(i));

    }


    @Override
    public int getItemCount() {

        return mValues.size();
    }

    /*public interface ItemListener {
        void onItemClick(DataModel item);
    }*/

}

