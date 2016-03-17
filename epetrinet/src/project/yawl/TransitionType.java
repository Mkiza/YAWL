/**
 */
package project.yawl;

import org.pnml.tools.epnk.pnmlcoremodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link project.yawl.TransitionType#getText <em>Text</em>}</li>
 *   <li>{@link project.yawl.TransitionType#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see project.yawl.YawlPackage#getTransitionType()
 * @model
 * @generated
 */
public interface TransitionType extends Attribute {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The literals are from the enumeration {@link project.yawl.TransitionTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see project.yawl.TransitionTypes
	 * @see #setText(TransitionTypes)
	 * @see project.yawl.YawlPackage#getTransitionType_Text()
	 * @model
	 * @generated
	 */
	TransitionTypes getText();

	/**
	 * Sets the value of the '{@link project.yawl.TransitionType#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see project.yawl.TransitionTypes
	 * @see #getText()
	 * @generated
	 */
	void setText(TransitionTypes value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TransitionType)
	 * @see project.yawl.YawlPackage#getTransitionType_Type()
	 * @model
	 * @generated
	 */
	TransitionType getType();

	/**
	 * Sets the value of the '{@link project.yawl.TransitionType#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TransitionType value);

} // TransitionType
