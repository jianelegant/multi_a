package mirror.libcore.io;

import mirror.RefClass;
import mirror.RefObject;

/**
 * @author yy
 */

public class ForwardingOs {
    public static Class<?> TYPE = RefClass.load(ForwardingOs.class, "libcore.io.ForwardingOs");
    public static RefObject<Object> os;
}
