/**
 */
package project.yawl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import project.yawl.Transition;
import project.yawl.TransitionType;
import project.yawl.YawlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link project.yawl.impl.TransitionImpl#getSplitType <em>Split Type</em>}</li>
 *   <li>{@link project.yawl.impl.TransitionImpl#getJoinType <em>Join Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends org.pnml.tools.epnk.pnmlcoremodel.impl.TransitionImpl implements Transition {
	/**
	 * The cached value of the '{@link #getSplitType() <em>Split Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplitType()
	 * @generated
	 * @ordered
	 */
	protected TransitionType splitType;
	/**
	 * The cached value of the '{@link #getJoinType() <em>Join Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinType()
	 * @generated
	 * @ordered
	 */
	protected TransitionType joinType;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YawlPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType getSplitType() {
		if (splitType != null && splitType.eIsProxy()) {
			InternalEObject oldSplitType = (InternalEObject)splitType;
			splitType = (TransitionType)eResolveProxy(oldSplitType);
			if (splitType != oldSplitType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlPackage.TRANSITION__SPLIT_TYPE, oldSplitType, splitType));
			}
		}
		return splitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType basicGetSplitType() {
		return splitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplitType(TransitionType newSplitType) {
		TransitionType oldSplitType = splitType;
		splitType = newSplitType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLIT_TYPE, oldSplitType, splitType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType getJoinType() {
		if (joinType != null && joinType.eIsProxy()) {
			InternalEObject oldJoinType = (InternalEObject)joinType;
			joinType = (TransitionType)eResolveProxy(oldJoinType);
			if (joinType != oldJoinType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, YawlPackage.TRANSITION__JOIN_TYPE, oldJoinType, joinType));
			}
		}
		return joinType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionType basicGetJoinType() {
		return joinType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinType(TransitionType newJoinType) {
		TransitionType oldJoinType = joinType;
		joinType = newJoinType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOIN_TYPE, oldJoinType, joinType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				if (resolve) return getSplitType();
				return basicGetSplitType();
			case YawlPackage.TRANSITION__JOIN_TYPE:
				if (resolve) return getJoinType();
				return basicGetJoinType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				setSplitType((TransitionType)newValue);
				return;
			case YawlPackage.TRANSITION__JOIN_TYPE:
				setJoinType((TransitionType)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				setSplitType((TransitionType)null);
				return;
			case YawlPackage.TRANSITION__JOIN_TYPE:
				setJoinType((TransitionType)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLIT_TYPE:
				return splitType != null;
			case YawlPackage.TRANSITION__JOIN_TYPE:
				return joinType != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
