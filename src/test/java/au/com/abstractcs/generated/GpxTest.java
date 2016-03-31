package au.com.abstractcs.generated;

import au.com.abstractcs.gpx.generated.GpxType;
import au.com.abstractcs.gpx.generated.TrkType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 * Created by john.templeton on 29/03/2016.
 */
public class GpxTest {

    private static final String TEST_FILE = "Solo_ride.gpx";
    public static void main(String args[]) {
        GpxTest gpxTest = new GpxTest();
        gpxTest.loadGPX();
    }

    void loadGPX() {
        GpxType gpx = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("au.com.abstractcs.gpx.generated");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<GpxType> root = (JAXBElement<GpxType>) unmarshaller
                    .unmarshal(new File(".", TEST_FILE));
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
