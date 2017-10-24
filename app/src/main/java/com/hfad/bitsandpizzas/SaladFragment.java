package com.hfad.bitsandpizzas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaladFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView saladRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_salad, container, false);

        String[] saladNames = new String[Salad.salads.length];

        for (int i = 0; i < saladNames.length; i++) {
            saladNames[i] = Salad.salads[i].getName();
        }

        int[] saladImages = new int[Salad.salads.length];

        for (int i = 0; i < saladImages.length; i++) {
            saladImages[i] = Salad.salads[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(saladNames, saladImages);
        saladRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        saladRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SaladDetailActivity.class);
                intent.putExtra(SaladDetailActivity.EXTRA_SALAD_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return saladRecycler;
    }
}