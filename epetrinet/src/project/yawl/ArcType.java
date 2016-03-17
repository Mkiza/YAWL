/**
 */
package project.yawl;

import org.pnml.tools.epnk.pnmlcoremodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link project.yawl.ArcType#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see project.yawl.YawlPackage#getArcType()
 * @model
 * @generated
 */
public interface ArcType extends Attribute {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The literals are from the enumeration {@link project.yawl.ArcTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see project.yawl.ArcTypes
	 * @see #setText(ArcTypes)
	 * @see project.yawl.YawlPackage#getArcType_Text()
	 * @model
	 * @generated
	 */
	ArcTypes getText();

	/**
	 * Sets the value of the '{@link project.yawl.ArcType#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see project.yawl.ArcTypes
	 * @see #getText()
	 * @generated
	 */
	void setText(ArcTypes value);

} // ArcType
