package week6woman.graphics.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.TransitionFigure;

import project.yawl.TransitionType;
import project.yawl.TransitionTypes;
import project.yawl.Transition;

public class TransitionGraphics extends TransitionFigure {

	private enum JoinType {
		NORMAL, AND, OR, XOR
	}

	private enum SplitType {
		NORMAL, AND, OR, XOR
	}

	private JoinType joinType;
	private SplitType splitType;

	public TransitionGraphics(Transition transition) {
		super(transition);
		splitType = getSplitType();
		joinType = getJoinType();
	}

	@Override
	public void update() {
		SplitType oldSplitType = splitType;
		splitType = getSplitType();
		JoinType oldJoinType = joinType;
		joinType = getJoinType();
		System.out.println("UPDATE");
		if (splitType != oldSplitType || joinType != oldJoinType) {
			this.repaint();
		}
	}

	@Override
	protected void fillShape(Graphics graphics) {
		super.fillShape(graphics);
		graphics.pushState();
		Rectangle rectangle = this.getClientArea();
		
		graphics.clipRect(rectangle);
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.setLineWidth(1);

		if (joinType == JoinType.AND) {
			
			System.out.println("AND");
			int x1 = rectangle.x;
			int y1 = rectangle.y;
			int x2 = rectangle.x;
			int y2 = rectangle.y + rectangle.height;
			int x3 = rectangle.x + rectangle.width / 3;
			int y3 = rectangle.y + rectangle.height / 2;
			graphics.drawLine(x1, y1, x3, y3);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.drawLine(x3, y1, x3, y2);
			
		} else if (joinType == JoinType.OR) {
			System.out.println("OR");
			int x1 = rectangle.x + rectangle.width / 6;
			int y1 = rectangle.y;
			int x2 = rectangle.x;
			int y2 = rectangle.y + rectangle.height / 2;
			int x3 = rectangle.x + rectangle.width / 3;
			int y3 = rectangle.y + rectangle.height / 2;
			int x4 = rectangle.x + rectangle.width / 6;
			int y4 = rectangle.y + rectangle.height;
			graphics.drawLine(x1, y1, x2, y2);
		
			graphics.drawLine(x2, y2, x4, y4);
			graphics.drawLine(x4, y4, x3, y3);
			graphics.drawLine(x3, y3, x1, y1);
			graphics.drawLine(x3, y1, x3, y4);	

		} else if (joinType == JoinType.XOR) {
			System.out.println("XOR");
			int x1 = rectangle.x;
			int y1 = rectangle.y + rectangle.height / 2;
			int x2 = rectangle.x + rectangle.width / 3;
			int y2 = rectangle.y;
			int x3 = rectangle.x + rectangle.width / 3;
			int y3 = rectangle.y + rectangle.height;
			graphics.drawLine(x1, y1, x3, y3);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.drawLine(x1, y1, x2, y2);

		}
		
		if (splitType == SplitType.AND) {
			System.out.println("AND");
			int x1 = rectangle.x + rectangle.width;
			int y1 = rectangle.y;
			int x2 = rectangle.x + rectangle.width;
			int y2 = rectangle.y + rectangle.height;
			int x3 = rectangle.x + rectangle.width * 2 / 3;
			int y3 = rectangle.y + rectangle.height / 2;
			graphics.drawLine(x1, y1, x3, y3);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.drawLine(x1, y1, x2, y2);
			graphics.drawLine(x3, y1, x3, y2);

		} else if (splitType == SplitType.OR) {
			System.out.println("OR");
			int x1 = rectangle.x + rectangle.width * 5 / 6;
			int y1 = rectangle.y;
			int x2 = rectangle.x + rectangle.width;
			int y2 = rectangle.y + rectangle.height / 2;
			int x3 = rectangle.x + rectangle.width * 2 / 3;
			int y3 = rectangle.y + rectangle.height / 2;
			int x4 = rectangle.x + rectangle.width * 5 / 6;
			int y4 = rectangle.y + rectangle.height;
			graphics.drawLine(x1, y1, x2, y2);
			graphics.drawLine(x2, y2, x4, y4);
			graphics.drawLine(x4, y4, x3, y3);
			graphics.drawLine(x3, y3, x1, y1);
			graphics.drawLine(x3, y1, x3, y4);

		} else if (splitType == SplitType.XOR) {
			System.out.println("XOR");
			int x1 = rectangle.x + rectangle.width * 2 / 3;
			int y1 = rectangle.y;
			int x2 = rectangle.x + rectangle.width * 2 / 3;
			int y2 = rectangle.y + rectangle.height;
			int x3 = rectangle.x + rectangle.width;
			int y3 = rectangle.y + rectangle.height/2;
			graphics.drawLine(x1, y1, x3, y3);
			graphics.drawLine(x3, y3, x2, y2);
			graphics.drawLine(x1, y1, x2, y2);
			
		}
		graphics.popState();
	}

	private JoinType getJoinType() {
		if (this.transition instanceof Transition) {
			TransitionType transitiontype = ((Transition) transition).getJoinType();

			if (transitiontype != null) {
				if (transitiontype.getText().getValue() == TransitionTypes.AND_VALUE) {
					return JoinType.AND;
				} else if (transitiontype.getText().getValue() == TransitionTypes.OR_VALUE) {
					return JoinType.OR;
				} else {
					return JoinType.XOR;
				}
			}
			return JoinType.NORMAL;
		}
		return JoinType.NORMAL;
	}

	private SplitType getSplitType() {
		if (this.transition instanceof Transition) {
			TransitionType transitiontype = ((Transition) transition).getSplitType();

			if (transitiontype != null) {
				if (transitiontype.getText().getValue() == TransitionTypes.AND_VALUE) {
					return SplitType.AND;
				} else if (transitiontype.getText().getValue() == TransitionTypes.OR_VALUE) {
					return SplitType.OR;
				} else {
					return SplitType.XOR;
				}
			}
			return SplitType.NORMAL;
		}
		return SplitType.NORMAL;
	}
}