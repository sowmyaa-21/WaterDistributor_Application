package com.example.waterdistributorapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<DealerDetails,MyAdapter.myviewholder> {
    Context context;
    public MyAdapter(@NonNull FirebaseRecyclerOptions<DealerDetails> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final DealerDetails dealerDetails) {
        holder.companyname.setText(dealerDetails.getDealercompanyname());
        holder.location.setText(dealerDetails.getDealerlocation());
        holder.name.setText(dealerDetails.getDealername());
        holder.phone.setText(dealerDetails.getDealerphonenumber());

        holder.callbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobileno = dealerDetails.getDealerphonenumber();
                String call = "tel:" + mobileno.trim();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(call));
                view.getContext().startActivity(intent);
            }


        });


}
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView companyname,location,name,phone;
        ImageButton callbutton;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            companyname=(TextView) itemView.findViewById(R.id.companynametext);
            location=(TextView) itemView.findViewById(R.id.locationtext);
            name=(TextView) itemView.findViewById(R.id.nametext);
            phone=(TextView) itemView.findViewById(R.id.phonetext);
            callbutton=(ImageButton)itemView.findViewById(R.id.callButton);


        }
    }
}
