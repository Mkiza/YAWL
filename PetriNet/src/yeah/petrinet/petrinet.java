/**
 */
package yeah.petrinet;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>petrinet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yeah.petrinet.petrinet#getArcs <em>Arcs</em>}</li>
 *   <li>{@link yeah.petrinet.petrinet#getNodes <em>Nodes</em>}</li>
 *   <li>{@link yeah.petrinet.petrinet#getNume <em>Nume</em>}</li>
 * </ul>
 *
 * @see yeah.petrinet.PetrinetPackage#getpetrinet()
 * @model
 * @generated
 */
public interface petrinet extends EObject {
	/**
	 * Returns the value of the '<em><b>Arcs</b></em>' containment reference list.
	 * The list contents are of type {@link yeah.petrinet.Arc}.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Arc#getPetrinet <em>Petrinet</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arcs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arcs</em>' containment reference list.
	 * @see yeah.petrinet.PetrinetPackage#getpetrinet_Arcs()
	 * @see yeah.petrinet.Arc#getPetrinet
	 * @model opposite="petrinet" containment="true"
	 * @generated
	 */
	EList<Arc> getArcs();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link yeah.petrinet.Node}.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Node#getPetrinet <em>Petrinet</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see yeah.petrinet.PetrinetPackage#getpetrinet_Nodes()
	 * @see yeah.petrinet.Node#getPetrinet
	 * @model opposite="petrinet" containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Nume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nume</em>' attribute.
	 * @see #setNume(String)
	 * @see yeah.petrinet.PetrinetPackage#getpetrinet_Nume()
	 * @model
	 * @generated
	 */
	String getNume();

	/**
	 * Sets the value of the '{@link yeah.petrinet.petrinet#getNume <em>Nume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nume</em>' attribute.
	 * @see #getNume()
	 * @generated
	 */
	void setNume(String value);

} // petrinet
