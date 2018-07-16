package com.example.a1513iron.app_meucampus_release1.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.a1513iron.app_meucampus_release1.Activities.listener.OnListClickInteractionListener;
import com.example.a1513iron.app_meucampus_release1.R;
import com.example.a1513iron.app_meucampus_release1.classes.Solucao_OutOfMemory;

import uk.co.senab.photoview.PhotoViewAttacher;

public class CalendarioViewHolder extends RecyclerView.ViewHolder {

    public ImageView imagem;
    private PhotoViewAttacher pAttacher;
    public CalendarioViewHolder(View itemView) {
        super(itemView);
        this.imagem = (ImageView) itemView.findViewById(R.id.imagem_calendario);
    }

    public void bindData(final int src,final Context context,final OnListClickInteractionListener listener){
        //this.imagem.setImageBitmap(Solucao_OutOfMemory.decodeSampledBitmapFromResource(context.getResources(),src,500,500));
        if (isImagePosition(src)) {
            Glide.with(this.imagem).load(src).into(imagem);
            this.pAttacher = new PhotoViewAttacher(imagem);
            this.pAttacher.update();

            this.imagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(src,view);
                }
            });
        }else{
            Glide.with(this.imagem).clear(this.imagem);
            this.imagem.setImageResource(R.drawable.ic_launcher_background);
        }


    }

    private boolean isImagePosition(int src){
        if(src == 0){
            return false;
        }else{
            return true;
        }
    }
}
