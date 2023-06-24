import edu.duke.*;
import java.io.*;
public class ImageProcessor {
    // Get the image you want to convert to Gray Scale.
    public ImageResource makeGray (ImageResource inImage) {
        // Create an outImage of the same size as inImage.
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight()); // Set outImage to the same width
                                                                                            // and height as inImage.
        // Iterate over each pixel in outImage using the method .pixels() (returns an iterable of each pixel in an image).
        for (Pixel pixel : outImage.pixels()) {
            // Get the pixel of in image at the same coordinates as the pixel of out image.
            Pixel inImagePixel = inImage.getPixel(pixel.getX(), pixel.getY());
            // Compute the average of the RGB values of the pixel of inImage.
            int average = (inImagePixel.getRed() + inImagePixel.getGreen() + inImagePixel.getBlue())/3;
            // Set the RGB values of outImage to the average computed.
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        // Return the converted image.
        return outImage;
    }
    
    public ImageResource invertImage (ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inImagePixel = inImage.getPixel(pixel.getX(), pixel.getY());
          
            int invertedRed = 255 - inImagePixel.getRed();
            int invertedGreen = 255 - inImagePixel.getGreen();
            int invertedBlue = 255 - inImagePixel.getBlue();
            
            pixel.setRed(invertedRed);
            pixel.setGreen(invertedGreen);
            pixel.setBlue(invertedBlue);
            
        }
        return outImage;
    }
    
    public void testGray () {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    
    public void selectAndConvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeGray(inImage);
            saveImage(outImage, inImage.getFileName(), "gray-");
        }
    }
    
    public void selectAndInvert () {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource invertedImage = invertImage(inImage);
            saveImage(invertedImage, inImage.getFileName(), "inverted-");
        }
    }
    
    public void saveImage (ImageResource ir, String fileName, String prefix) {
        ir.setFileName(prefix + fileName);
        ir.save();
    }
    
    
    
}
