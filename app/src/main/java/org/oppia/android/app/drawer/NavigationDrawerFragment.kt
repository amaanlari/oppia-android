package org.oppia.android.app.drawer

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import org.oppia.android.app.fragment.FragmentComponentImpl
import org.oppia.android.app.fragment.InjectableFragment
import javax.inject.Inject

/** [NavigationDrawerFragment] to show navigation drawer. */
class NavigationDrawerFragment :
  InjectableFragment(),
  RouteToProfileProgressListener,
  ExitProfileDialogInterface {

  @Inject
  lateinit var navigationDrawerFragmentPresenter: NavigationDrawerFragmentPresenter

  override fun onAttach(context: Context) {
    super.onAttach(context)
    (fragmentComponent as FragmentComponentImpl).inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return navigationDrawerFragmentPresenter.handleCreateView(inflater, container)
  }

  fun initializeDrawer(drawerLayout: DrawerLayout, toolbar: Toolbar, menuItemId: Int) {
    navigationDrawerFragmentPresenter.initializeDrawer(drawerLayout, toolbar, menuItemId)
  }

  override fun routeToProfileProgress(profileId: Int) {
    navigationDrawerFragmentPresenter.openProfileProgress(profileId)
  }

  override fun highlightLastCheckedMenuItem() {
    navigationDrawerFragmentPresenter.highlightLastCheckedMenuItem()
  }

  override fun highlightAdministratorControlsItem() {
    navigationDrawerFragmentPresenter.highlightAdministratorControlsItem()
  }

  override fun highlightDeveloperOptionsItem() {
    navigationDrawerFragmentPresenter.highlightDeveloperOptionsItem()
  }

  override fun unhighlightSwitchProfileMenuItem() {
    navigationDrawerFragmentPresenter.unhighlightSwitchProfileMenuItem()
  }
}
