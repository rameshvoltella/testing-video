package band.full.testing.video.generator;

import band.full.testing.video.core.Framerate;
import band.full.testing.video.core.Resolution;
import band.full.testing.video.encoder.DecoderY4M;
import band.full.testing.video.encoder.EncoderParameters;
import band.full.testing.video.encoder.EncoderY4M;
import band.full.testing.video.itu.ColorMatrix;
import band.full.testing.video.itu.TransferCharacteristics;

/**
 * @author Igor Malinin
 */
public abstract class ParametrizedGeneratorBase<A> {
    public final GeneratorFactory factory;
    public final EncoderParameters params;
    public final Resolution resolution;
    public final ColorMatrix matrix;
    public final Framerate framerate;
    public final TransferCharacteristics transfer;
    public final int width, height;

    public final String folder, pattern;

    public ParametrizedGeneratorBase(GeneratorFactory factory,
            EncoderParameters params, String folder, String pattern) {
        this.factory = factory;
        this.params = params;
        this.folder = folder;
        this.pattern = pattern;

        resolution = params.resolution;
        matrix = params.matrix;
        framerate = params.framerate;

        transfer = matrix.transfer;

        width = resolution.width;
        height = resolution.height;
    }

    public void generate(A args) {
        factory.generate(getFileName(args), params, args,
                this::encode, this::verify);
    }

    protected abstract String getFileName(A args);

    protected abstract void encode(EncoderY4M e, A args);

    protected abstract void verify(DecoderY4M d, A args);
}
