package cat.fiberfarra.fiberbar.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import cat.fiberfarra.fiberbar.R;
import cat.fiberfarra.fiberbar.databinding.FragmentMenuViewBinding;

/**
 * A placeholder fragment containing a simple view.
 */


public class PlaceholderFragment extends Fragment {
    private int index;
    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentMenuViewBinding binding;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        index=1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        if(index==1) {
            return inflater.inflate(R.layout.fragment_menu_view, null);
        }
        else if(index==2){
            return inflater.inflate(R.layout.fragment_menu_view2, null);
        }
        else if(index==3){
            return inflater.inflate(R.layout.fragment_menu_view3, null);
        }
        else {
            return inflater.inflate(R.layout.fragment_menu_view4, null);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}