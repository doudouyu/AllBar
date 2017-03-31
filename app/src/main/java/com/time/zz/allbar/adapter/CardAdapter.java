package com.time.zz.allbar.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.time.zz.allbar.R;
import com.time.zz.allbar.data.Card;
import com.time.zz.allbar.utils.GlideImageUtils;

import java.util.List;

/**
 * Created by admin on 2017/3/29.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private  Context context;
    private  List<Card> cardLists;
    private CardViewHolder cardviewholder;


    public CardAdapter(Context context, List<Card> cardLists) {
        this.cardLists=cardLists;
        this.context=context;
    }
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         cardviewholder = new CardViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview_activity,parent,false));
        return cardviewholder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder cardviewholder, int position) {
       /* final Card card =cardLists.get(position);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cardviewholder.card_image.getLayoutParams();
        float itemWidth = (ScreenUtils.getScreenWidth(cardviewholder.itemView.getContext()) - 8*3) / 3;
        layoutParams.width = (int) itemWidth;
        float scale = (itemWidth+0f)/card.width;
        layoutParams.height= (int) (card.height*scale);
        cardviewholder.card_image.setLayoutParams(layoutParams);*/
        cardviewholder.card_text.setText(cardLists.get(position).getName());
        GlideImageUtils.Center(context,cardLists.get(position).getCardId(),cardviewholder.card_image);

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
    @Override
    public int getItemCount() {
        return cardLists.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView card_image;
        private TextView card_text;
        public CardViewHolder(View itemView) {
            super(itemView);
            card_image= (ImageView) itemView.findViewById(R.id.card_image);
            card_text= (TextView) itemView.findViewById(R.id.card_text);

        }
    }
}
