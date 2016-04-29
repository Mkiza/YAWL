/**
 */
package Anno.impl;

import Anno.AnnoPackage;
import Anno.EnabledTransition;
import Anno.Mode;
import Anno.SelectArc;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.pnml.tools.epnk.annotations.netannotations.impl.ObjectAnnotationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enabled Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Anno.impl.EnabledTransitionImpl#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link Anno.impl.EnabledTransitionImpl#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link Anno.impl.EnabledTransitionImpl#getMode <em>Mode</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnabledTransitionImpl extends ObjectAnnotationImpl implements EnabledTransition {
	/**
	 * The cached value of the '{@link #getInArcs() <em>In Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectArc> inArcs;

	/**
	 * The cached value of the '{@link #getOutArcs() <em>Out Arcs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutArcs()
	 * @generated
	 * @ordered
	 */
	protected EList<SelectArc> outArcs;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final Mode MODE_EDEFAULT = Mode.FIRED;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected Mode mode = MODE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnabledTransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnnoPackage.Literals.ENABLED_TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SelectArc> getInArcs() {
		if (inArcs == null) {
			inArcs = new EObjectWithInverseResolvingEList<SelectArc>(SelectArc.class, this, AnnoPackage.ENABLED_TRANSITION__IN_ARCS, AnnoPackage.SELECT_ARC__TARGET_TRANSITION);
		}
		return inArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SelectArc> getOutArcs() {
		if (outArcs == null) {
			outArcs = new EObjectWithInverseResolvingEList<SelectArc>(SelectArc.class, this, AnnoPackage.ENABLED_TRANSITION__OUT_ARCS, AnnoPackage.SELECT_ARC__SOURCE_TRANSITION);
		}
		return outArcs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnnoPackage.ENABLED_TRANSITION__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnnoPackage.ENABLED_TRANSITION__IN_ARCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInArcs()).basicAdd(otherEnd, msgs);
			case AnnoPackage.ENABLED_TRANSITION__OUT_ARCS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutArcs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnnoPackage.ENABLED_TRANSITION__IN_ARCS:
				return ((InternalEList<?>)getInArcs()).basicRemove(otherEnd, msgs);
			case AnnoPackage.ENABLED_TRANSITION__OUT_ARCS:
				return ((InternalEList<?>)getOutArcs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnnoPackage.ENABLED_TRANSITION__IN_ARCS:
				return getInArcs();
			case AnnoPackage.ENABLED_TRANSITION__OUT_ARCS:
				return getOutArcs();
			case AnnoPackage.ENABLED_TRANSITION__MODE:
				return getMode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnnoPackage.ENABLED_TRANSITION__IN_ARCS:
				getInArcs().clear();
				getInArcs().addAll((Collection<? extends SelectArc>)newValue);
				return;
			case AnnoPackage.ENABLED_TRANSITION__OUT_ARCS:
				getOutArcs().clear();
				getOutArcs().addAll((Collection<? extends SelectArc>)newValue);
				return;
			case AnnoPackage.ENABLED_TRANSITION__MODE:
				setMode((Mode)newValue);
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
			case AnnoPackage.ENABLED_TRANSITION__IN_ARCS:
				getInArcs().clear();
				return;
			case AnnoPackage.ENABLED_TRANSITION__OUT_ARCS:
				getOutArcs().clear();
				return;
			case AnnoPackage.ENABLED_TRANSITION__MODE:
				setMode(MODE_EDEFAULT);
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
			case AnnoPackage.ENABLED_TRANSITION__IN_ARCS:
				return inArcs != null && !inArcs.isEmpty();
			case AnnoPackage.ENABLED_TRANSITION__OUT_ARCS:
				return outArcs != null && !outArcs.isEmpty();
			case AnnoPackage.ENABLED_TRANSITION__MODE:
				return mode != MODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //EnabledTransitionImpl
