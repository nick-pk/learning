import util.Style;

import java.io.IOException;

interface Converter<T> {
    public void convert(T source, T destination, Style style) throws IOException;
}