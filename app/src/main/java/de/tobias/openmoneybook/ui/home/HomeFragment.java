package de.tobias.openmoneybook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import de.tobias.openmoneybook.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
	
	private FragmentHomeBinding binding;
	
	public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
		
		binding = FragmentHomeBinding.inflate(inflater, container, false);
		View root = binding.getRoot();
		
		final TextView titleText = binding.textView;
		homeViewModel.getTitleText().observe(getViewLifecycleOwner(), titleText::setText);
		
		final TextView centerText = binding.centerText;
		homeViewModel.getBalanceText().observe(getViewLifecycleOwner(), centerText::setText);
		
		final ProgressBar pBarSpent = binding.statsProgressbar;
		homeViewModel.getProgress().observe(getViewLifecycleOwner(), pBarSpent::setProgress);
		
		return root;
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		binding = null;
	}
}
