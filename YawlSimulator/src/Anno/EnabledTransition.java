/**
 */
package Anno;

import org.eclipse.emf.common.util.EList;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enabled Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Anno.EnabledTransition#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link Anno.EnabledTransition#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link Anno.EnabledTransition#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @see Anno.AnnoPackage#getEnabledTransition()
 * @model
 * @generated
 */
public interface EnabledTransition extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
	 * The list contents are of type {@link Anno.SelectArc}.
	 * It is bidirectional and its opposite is '{@link Anno.SelectArc#getTargetTransition <em>Target Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Arcs</em>' reference list.
	 * @see Anno.AnnoPackage#getEnabledTransition_InArcs()
	 * @see Anno.SelectArc#getTargetTransition
	 * @model opposite="TargetTransition"
	 * @generated
	 */
	EList<SelectArc> getInArcs();

	/**
	 * Returns the value of the '<em><b>Out Arcs</b></em>' reference list.
	 * The list contents are of type {@link Anno.SelectArc}.
	 * It is bidirectional and its opposite is '{@link Anno.SelectArc#getSourceTransition <em>Source Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Arcs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Arcs</em>' reference list.
	 * @see Anno.AnnoPackage#getEnabledTransition_OutArcs()
	 * @see Anno.SelectArc#getSourceTransition
	 * @model opposite="SourceTransition"
	 * @generated
	 */
	EList<SelectArc> getOutArcs();

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link Anno.Mode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see Anno.Mode
	 * @see #setMode(Mode)
	 * @see Anno.AnnoPackage#getEnabledTransition_Mode()
	 * @model
	 * @generated
	 */
	Mode getMode();

	/**
	 * Sets the value of the '{@link Anno.EnabledTransition#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see Anno.Mode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(Mode value);

} // EnabledTransition
