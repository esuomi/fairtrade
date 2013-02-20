package fairtrade.util;

import java.nio.ByteBuffer;

/**
 * @author Esko Suomi <suomi.esko@gmail.com>
 * @since 20.2.2013
 */
public class ByteUtils {
    // TODO: move to some util or use Guava
    public static final byte[] intToByteArray(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public static int byteArrayToInt(byte[] requestBody) {
        return ByteBuffer.wrap(requestBody).asIntBuffer().get();
    }
}
