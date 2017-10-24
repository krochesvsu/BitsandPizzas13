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
public class StoresFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView storeRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_store, container, false);

        String[] storeNames = new String[Stores.stores.length];

        for (int i = 0; i < storeNames.length; i++) {
            storeNames[i] = Stores.stores[i].getName();
        }

        int[] storeImages = new int[Stores.stores.length];

        for (int i = 0; i < storeImages.length; i++) {
            storeImages[i] = Stores.stores[i].getImageResourceId();
        }

        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(storeNames, storeImages);
        storeRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        storeRecycler.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), StoreDetailActivity.class);
                intent.putExtra(StoreDetailActivity.EXTRA_STORE_ID, position);
                getActivity().startActivity(intent);
            }
        });

        return storeRecycler;
    }
}