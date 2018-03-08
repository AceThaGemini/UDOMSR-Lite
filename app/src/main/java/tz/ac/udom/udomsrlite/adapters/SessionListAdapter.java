package tz.ac.udom.udomsrlite.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tz.ac.udom.udomsrlite.R;
import tz.ac.udom.udomsrlite.activities.SessionDetailActivity;

/**
 * Created by ali on 3/8/18.
 */

public class SessionListAdapter extends RecyclerView.Adapter<SessionListAdapter.ViewHolder> {


    private Context context;

    public SessionListAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textCourse, textInstructor, textTime, textVenue;

        public ViewHolder(View itemView) {
            super(itemView);

            textCourse = itemView.findViewById(R.id.textCourse);
            textInstructor = itemView.findViewById(R.id.textInstructor);
            textTime = itemView.findViewById(R.id.textTime);
            textVenue = itemView.findViewById(R.id.textVenue);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // do magic
                    // TODO: 3/8/18 pass session to detail activity, to verify
                    context.startActivity(new Intent(context, SessionDetailActivity.class)
                            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });
        }
    }

    @Override
    public SessionListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_session, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SessionListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
