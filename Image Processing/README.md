# Programming Exercise: Batch Grayscale and Image Inversion

## Description:
The ImageProcessor code is a Java program that provides functionality for image manipulation. This code represents the solution to the extra assignment provided at the end of the "Java Programming: Solving Problems With Software" course on Coursera.

Features and Functionality:

- Convert to Gray Scale: The program can convert an image to grayscale by iterating over each pixel, computing the average of its RGB values, and setting the RGB values of the corresponding pixel in the output image to the computed average.

- Invert Image: It can invert the colors of an image by subtracting each RGB value from 255 (the maximum value) and setting the resulting values in the output image.

- Test Gray Conversion: The code includes a test method that allows users to select an image and view the grayscale conversion.

- Select and Convert: The program enables users to select multiple images from a directory and convert them to grayscale. The converted images are then saved with a "gray-" prefix.

- Select and Invert: Users can select multiple images from a directory and invert their colors. The inverted images are saved with an "inverted-" prefix.

- Save Image: A helper method is provided to set the filename and save the image with the specified prefix.

### Usage:
Users can utilize the ImageProcessor code by instantiating an object of the class and calling the desired methods based on their requirements. The code supports grayscale conversion, color inversion, and batch processing of images in a directory.

### Note:
This code is part of an extra assignment provided at the end of the "Java Programming: Solving Problems With Software" course on Coursera, and successful completion of this assignment contributes to earning the certification with honors.