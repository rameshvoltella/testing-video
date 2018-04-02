package band.full.test.video.generate.hdr10;

import static band.full.test.video.generator.GeneratorFactory.HEVC;
import static band.full.video.encoder.EncoderParameters.HDR10;

import band.full.test.video.executor.GenerateVideo;
import band.full.test.video.generator.CalibrationBase;

/**
 * Calibration box fills.
 *
 * @author Igor Malinin
 */
@GenerateVideo
public class Calibrate2160pHDR10 extends CalibrationBase {
    public Calibrate2160pHDR10() {
        super(HEVC, HDR10, "UHD4K/HDR10/Calibrate", "U4K_HDR10");
    }
}
