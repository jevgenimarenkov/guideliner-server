package ee.ttu.usability.guideliner.domain.attribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Html extends AbstractAttribute {

    private boolean isValid;

    private Lang lang;

    private AlternativeText alternativeText;

    private Viewport viewport;

    private Flash flash;

    private Bolt bolt;

    private Italics italics;

    private Font font;

    private BaseFont baseFont;

    private H1 h1;

    private H2 h2;

    private H3 h3;

    private H4 h4;

    private H5 h5;

    private Marquee marquee;

    private Blink blink;

    private Id id;

    private P p;

    private Div div;

    private Td td;

}
