package wisc.virgil.virgil;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *  Written by   : Munish Kapoor
 *  Original Code:
 *  http://manishkpr.webheavens.com/android-material-design-tabs-collapsible-example/
 **/

public class PostsFragment extends Fragment {

    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    public static Fragment newInstance(Context context) {
        PostsFragment f = new PostsFragment();
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.gallery_content, null);
        setUpView(root);
        return root;
    }

    void setUpView(ViewGroup root){
        ButterKnife.bind(this, root);
        setUPList();
    }

    void setUPList(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        CommonRecycleAdapter adapter = new CommonRecycleAdapter(createItemList(), createItemTitle(),
                createItemHeader());
        recyclerView.setAdapter(adapter);
    }

    private List<String> createItemList() {
        List<String> itemList = new ArrayList<>();
        for(int i=0;i<30;i++) {
            itemList.add("Title : " + i);
        }
        return itemList;
    }

    private List<String> createItemTitle() {
        List<String> titleList = new ArrayList<>();

        for(int i=0; i<30; i++) {
            titleList.add("Here is some basic info : " + i);
        }
        return titleList;
    }

    private List<String> createItemHeader() {
        List<String> headerList = new ArrayList<>();

        for (int i=0; i<30; i++) {
            headerList.add("Virgil Header : " + i);
        }

        return headerList;
    }
}