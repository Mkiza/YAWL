/**
 */
package yeah.petrinet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Token</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link yeah.petrinet.Token#getPlace <em>Place</em>}</li>
 * </ul>
 *
 * @see yeah.petrinet.PetrinetPackage#getToken()
 * @model
 * @generated
 */
public interface Token extends EObject {

	/**
	 * Returns the value of the '<em><b>Place</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link yeah.petrinet.Place#getTokens <em>Tokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Place</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Place</em>' container reference.
	 * @see #setPlace(Place)
	 * @see yeah.petrinet.PetrinetPackage#getToken_Place()
	 * @see yeah.petrinet.Place#getTokens
	 * @model opposite="tokens" transient="false"
	 * @generated
	 */
	Place getPlace();

	/**
	 * Sets the value of the '{@link yeah.petrinet.Token#getPlace <em>Place</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Place</em>' container reference.
	 * @see #getPlace()
	 * @generated
	 */
	void setPlace(Place value);
} // Token
