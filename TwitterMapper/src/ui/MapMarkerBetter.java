package ui;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class MapMarkerBetter extends MapMarkerCircle {
    public static final double defaultMarkerSize = 5.0;
    public static final Color defaultColor = Color.red;
    private BufferedImage profilePic;
    private String profilePicURL;
    private String tweetText;

    public MapMarkerBetter(Layer layer, Coordinate coordinate, Color color, BufferedImage profilePic, String profilePicURL, String tweetText) {
        super(layer, null, coordinate, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(Color.BLACK);
        setBackColor(color);
        this.profilePic = profilePic;
        this.profilePicURL = profilePicURL;
        this.tweetText = tweetText;
    }

	public void paint(Graphics g, Point position, int radius) {
		int size = radius * 5;
		int pictureSize = size - 10;
		if (g instanceof Graphics2D && this.getBackColor() != null) {
			Graphics2D g2 = (Graphics2D) g;
			Composite oldComposite = g2.getComposite();
			g2.setComposite(AlphaComposite.getInstance(3));
			g2.setPaint(this.getBackColor());
			g.fillOval(position.x - radius, position.y - radius, size, size);
			g.drawImage(profilePic, position.x, position.y, pictureSize, pictureSize, Color.black, null);
			g2.setComposite(oldComposite);
		}

		g.setColor(this.getColor());
		g.drawOval(position.x - radius, position.y - radius, size, size);
		if (this.getLayer() == null || this.getLayer().isVisibleTexts()) {
			this.paintText(g, position);
		}

	}

	public String getProfilePicURL() {
		return this.profilePicURL;
	}

	public BufferedImage getProfilePic() {
    	return this.profilePic;
	}

	public String getTweetText() {
    	return this.tweetText;
	}
}
