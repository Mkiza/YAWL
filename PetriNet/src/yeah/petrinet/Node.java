/**
 */
package yeah.petrinet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yeah.petrinet.Node#getIn <em>In</em>}</li>
 *   <li>{@link yeah.petrinet.Node#getOut <em>Out</em>}</li>
 *   <li>{@link yeah.petrinet.Node#getName <em>Name</em>}</li>
 *   <li>{@link yeah.petrinet.Node#getPetrinet <em>Petrinet</em>}</li>
 * </ul>
 *
 * @see yeah.petrinet.PetrinetPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>In</b></em>' reference list.
	 * The list contents are of type {@link yeah.petrinet.Arc}.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Arc#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' reference list.
	 * @see yeah.petrinet.PetrinetPackage#getNode_In()
	 * @see yeah.petrinet.Arc#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Arc> getIn();

	/**
	 * Returns the value of the '<em><b>Out</b></em>' reference list.
	 * The list contents are of type {@link yeah.petrinet.Arc}.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Arc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' reference list.
	 * @see yeah.petrinet.PetrinetPackage#getNode_Out()
	 * @see yeah.petrinet.Arc#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Arc> getOut();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see yeah.petrinet.PetrinetPackage#getNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link yeah.petrinet.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Petrinet</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.petrinet#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Petrinet</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Petrinet</em>' container reference.
	 * @see #setPetrinet(petrinet)
	 * @see yeah.petrinet.PetrinetPackage#getNode_Petrinet()
	 * @see yeah.petrinet.petrinet#getNodes
	 * @model opposite="nodes" transient="false"
	 * @generated
	 */
	petrinet getPetrinet();

	/**
	 * Sets the value of the '{@link yeah.petrinet.Node#getPetrinet <em>Petrinet</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Petrinet</em>' container reference.
	 * @see #getPetrinet()
	 * @generated
	 */
	void setPetrinet(petrinet value);

} // Node
