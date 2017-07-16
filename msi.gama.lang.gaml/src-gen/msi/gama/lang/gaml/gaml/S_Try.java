/**
 */
package msi.gama.lang.gaml.gaml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link msi.gama.lang.gaml.gaml.S_Try#getCatch <em>Catch</em>}</li>
 * </ul>
 *
 * @see msi.gama.lang.gaml.gaml.GamlPackage#getS_Try()
 * @model
 * @generated
 */
public interface S_Try extends Statement
{
  /**
   * Returns the value of the '<em><b>Catch</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Catch</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Catch</em>' containment reference.
   * @see #setCatch(Block)
   * @see msi.gama.lang.gaml.gaml.GamlPackage#getS_Try_Catch()
   * @model containment="true"
   * @generated
   */
  Block getCatch();

  /**
   * Sets the value of the '{@link msi.gama.lang.gaml.gaml.S_Try#getCatch <em>Catch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Catch</em>' containment reference.
   * @see #getCatch()
   * @generated
   */
  void setCatch(Block value);

} // S_Try
