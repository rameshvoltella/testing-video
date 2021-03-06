package band.full.test.video.generator;

import static java.util.function.Function.identity;

import band.full.test.video.encoder.EncoderParameters;
import band.full.test.video.executor.GenerateVideo;

import java.util.stream.Stream;

/**
 * Testing color bands separation / quantization step uniformity.
 * <p>
 * HDR PQ specialized version.
 *
 * @author Igor Malinin
 */
@GenerateVideo
public abstract class Quants2DBase10HDR extends Quants2DBase {
    protected Quants2DBase10HDR(GeneratorFactory factory,
            EncoderParameters params,
            String folder, String group) {
        super(factory, params, folder, group);
    }

    protected Quants2DBase10HDR(GeneratorFactory factory,
            EncoderParameters params, NalUnitPostProcessor<Args> processor,
            MuxerFactory muxer, String folder, String group) {
        super(factory, params, processor, muxer, folder, group);
    }

    @Override
    protected Stream<Args> args() {
        return Stream.of(
                quants("NearBlack", 64, 96),
                quants("DarkGray", 128, 192),
                quants("Gray", 256),
                quants("LightGray", 384),
                quants("NearWhite", 512),
                quants("Bright", 640),
                quants("Brighter", 768),
                quants("Brightest", 896)
        ).flatMap(identity());
    }
}
