package tz.ac.udom.udomsrlite.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.activities.SessionsListActivity;

/**
 * Created by ali on 3/7/18.
 */

public class ModulesMenuAdapter extends RecyclerView.Adapter<ModulesMenuAdapter.ViewHolder> {

    private Context context;

    public ModulesMenuAdapter(Context context) {

        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

            // click lister
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // do magic
                    // TODO: 3/8/18 launch a correct module
                    context.startActivity(new Intent(context, SessionsListActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });
        }
    }


    public ModulesMenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_module, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ModulesMenuAdapter.ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 7;
    }
}
