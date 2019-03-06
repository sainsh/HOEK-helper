package dk.kugelberg.hoek_helper.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dk.kugelberg.hoek_helper.model.VO;
import dk.kugelberg.hoek_helper.model.VOImpl;


public class MainActivityViewModel extends ViewModel {

    private VO vo = new VOImpl();
    private MutableLiveData<Double> currentVO = new MutableLiveData<>();

    public MainActivityViewModel(){
        currentVO.setValue(vo.getVaerdi());
    }

    public MutableLiveData<Double> getCurrentVO() {
        return currentVO;
    }

    public void setCurrentVO(Double vaerdi){
        currentVO.setValue(vaerdi);
    }
}
