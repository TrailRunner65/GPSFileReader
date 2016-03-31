package au.com.abstractcs.gpx;

import au.com.abstractcs.gpx.generated.GpxType;
import au.com.abstractcs.gpx.generated.TrkType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by john.templeton on 30/03/2016.
 */
public class GpxReader {

    void loadGPX(String filename) {
        GpxType gpx = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("au.com.abstractcs.gpx.generated");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<GpxType> root = (JAXBElement<GpxType>) unmarshaller
                    .unmarshal(new File(filename));
            gpx = root.getValue();
        } catch (JAXBException ex) {
            System.err.println(ex);
        }

        System.out.println("Creator: " + gpx.getCreator());
        System.out.println("Version: " + gpx.getVersion());

        System.out.println("Number of Tracks: " + gpx.getTrk().size());
        List<TrkType> tracks = gpx.getTrk();

        for (TrkType track : tracks) {
            System.out.println("Title: " + track.getName());
        }
    }

}
