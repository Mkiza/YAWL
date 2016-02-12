/**
 */
package yeah.petrinet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yeah.petrinet.Arc#getSource <em>Source</em>}</li>
 *   <li>{@link yeah.petrinet.Arc#getTarget <em>Target</em>}</li>
 *   <li>{@link yeah.petrinet.Arc#getPetrinet <em>Petrinet</em>}</li>
 * </ul>
 *
 * @see yeah.petrinet.PetrinetPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Node#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see yeah.petrinet.PetrinetPackage#getArc_Source()
	 * @see yeah.petrinet.Node#getOut
	 * @model opposite="out"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link yeah.petrinet.Arc#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Node#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see yeah.petrinet.PetrinetPackage#getArc_Target()
	 * @see yeah.petrinet.Node#getIn
	 * @model opposite="in"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link yeah.petrinet.Arc#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Petrinet</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.petrinet#getArcs <em>Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Petrinet</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Petrinet</em>' container reference.
	 * @see #setPetrinet(petrinet)
	 * @see yeah.petrinet.PetrinetPackage#getArc_Petrinet()
	 * @see yeah.petrinet.petrinet#getArcs
	 * @model opposite="arcs" transient="false"
	 * @generated
	 */
	petrinet getPetrinet();

	/**
	 * Sets the value of the '{@link yeah.petrinet.Arc#getPetrinet <em>Petrinet</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Petrinet</em>' container reference.
	 * @see #getPetrinet()
	 * @generated
	 */
	void setPetrinet(petrinet value);

} // Arc
