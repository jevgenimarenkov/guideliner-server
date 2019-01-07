package ee.ttu.usability.guideliner.domain.page;

import ee.ttu.usability.guideliner.domain.attribute.*;
import ee.ttu.usability.guideliner.domain.element.link.Link;
import ee.ttu.usability.guideliner.domain.pageattributes.Scroll;
import ee.ttu.usability.guideliner.domain.element.navigation.ProhibitedWords;
import ee.ttu.usability.guideliner.domain.pageattributes.HorizontalScroll;
import ee.ttu.usability.guideliner.domain.pageattributes.VerticalScroll;
import lombok.Data;
import ee.ttu.usability.guideliner.domain.element.UsabilityGuideline;

@Data
public class UIPage extends UsabilityGuideline {

	private HorizontalScroll horizontalScroll;

	private VerticalScroll verticalScroll;

	private Scroll scroll;
	
	private ProhibitedWords prohibitedWords;
	
    private Layout layout;
    
    private LoadTime loadTime;
    
    private Text text;
    
    private Html html;
    
    private Href href;
    
    private Title title;

    private Integer maxNumberOfInputs;

    private Onblur onblur;

    private OnFocus onFocus;

    private OnMouseOver onMouseOver;

    private OnMouseDown onMouseDown;

    private OnKeyDown onKeyDown;

    private OnMouseOut onMouseOut;

    private OnKeyPress onKeyPress;

    private Link link;

    private OnClick onClick;

    private OnKey onKey;

    private OnDbClick onDbClick;

}
