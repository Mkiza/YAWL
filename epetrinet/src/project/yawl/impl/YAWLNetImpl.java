/**
 */
package project.yawl.impl;

import org.eclipse.emf.ecore.EClass;
import org.pnml.tools.epnk.pnmlcoremodel.impl.PetriNetTypeImpl;

import project.yawl.YAWLNet;
import project.yawl.YawlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>YAWL Net</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class YAWLNetImpl extends PetriNetTypeImpl implements YAWLNet {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public YAWLNetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YawlPackage.Literals.YAWL_NET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return YawlPackage.eNS_URI;
	}

} //YAWLNetImpl
