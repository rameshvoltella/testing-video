package band.full.test.video.generate.hevc.u4k;

import static band.full.test.video.generator.GeneratorFactory.HEVC;
import static band.full.video.encoder.EncoderParameters.FULLHD_MAIN8;

import band.full.test.video.executor.GenerateVideo;
import band.full.test.video.generator.CalibrationBase;

/**
 * Calibration box fills.
 *
 * @author Igor Malinin
 */
@GenerateVideo
public class Calibrate2160pBT709 extends CalibrationBase {
    public Calibrate2160pBT709() {
        super(HEVC, FULLHD_MAIN8, "UHD4K/BT709/Calibrate", "U4K");
    }
}
