package com.xsz.util;

/**
 * 2019年4月17日下午10:51:07
 */


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * @author Bsea
 *
 */
public class TestThumbnailator {

    //API文档:http://coobird.github.io/thumbnailator/javadoc/0.4.8/net/coobird/thumbnailator/package-summary.html

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Thumbnails.of("BL_pre.jpg")
                    .sourceRegion(Positions.CENTER, 500, 500)
//				.size(200, 300)
//				.width(100)
//				.height(200)
//				.forceSize(400, 400)
                    .scale(0.8d)
//				.scale(0.5d, 0.8d)
//				.keepAspectRatio(false)
//				.rotate(90d)
                    .watermark(Positions.CENTER, ImageIO.read(new File("watermark.png")), 0.8f)
                    .outputQuality(0.75f)
                    .outputFormat("JPEG")
//				.asBufferedImage()
                    .toFile("out.jpeg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


