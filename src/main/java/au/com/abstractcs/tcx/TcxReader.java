package au.com.abstractcs.tcx;

import au.com.abstractcs.gpx.generated.TrkType;
import au.com.abstractcs.tcx.generated.ActivityListT;
import au.com.abstractcs.tcx.generated.ActivityT;
import au.com.abstractcs.tcx.generated.TrainingCenterDatabaseT;
import com.sun.glass.ui.android.Activity;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by john.templeton on 30/03/2016.
 */
public class TcxReader {

    void loadTCX(String filename) {
        TrainingCenterDatabaseT tcxDb = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("au.com.abstractcs.tcx.generated");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<TrainingCenterDatabaseT> root = (JAXBElement<TrainingCenterDatabaseT>) unmarshaller
                    .unmarshal(new File(filename));
            tcxDb = root.getValue();
        } catch (JAXBException ex) {
            System.err.println(ex);
        }

        System.out.println("Author: " + tcxDb.getAuthor());

        System.out.println("Number of activities: " + tcxDb.getActivities().getActivity().size());
        ActivityListT activities = tcxDb.getActivities();

        for (ActivityT activity : activities.getActivity()) {
            System.out.println("Sport: " + activity.getSport());
        }
    }

}
