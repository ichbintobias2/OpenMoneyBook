package de.tobias.openmoneybook.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
	
	private final MutableLiveData<String> titleText;
	private final MutableLiveData<String> balanceText;
	private final MutableLiveData<Integer> progress;
	
	public HomeViewModel() {
		// TODO get values from db
		final double gained = 2142.46;
		final double spent = 1438.75;
		
		titleText = new MutableLiveData<>();
		titleText.setValue("Current balance");
		
		balanceText = new MutableLiveData<>();
		balanceText.setValue(spent +" / "+ gained);
		
		progress = new MutableLiveData<>();
		progress.setValue((int) (spent / gained * 100));
	}
	
	public LiveData<String> getTitleText() {
		return titleText;
	}
	
	public LiveData<String> getBalanceText() {
		return balanceText;
	}
	
	public LiveData<Integer> getProgress() {
		return progress;
	}
}
