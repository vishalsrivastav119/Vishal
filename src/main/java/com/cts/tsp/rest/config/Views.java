/**
 * 
 */
package com.cts.tsp.rest.config;

/**
 * @author Somnath
 * 
 *         The application presents 3 kinds of views, a list view which is
 *         annotated to all the entity attributes that should appear in a
 *         listing on that entity. A details view is annotated for all the
 *         attributes whose details are being displayed and an internal view for
 *         the rest of the attributes. As the other views extend from the
 *         ListView any attribute marked as ListView will automatically be part
 *         of all the views. You can ofcourse annotate attributes with multiple
 *         views if required. This mechanism if to filter the attributes that
 *         are shown to the user from the entity(exposed domain model) instead
 *         of creating a DTO layer separately. You can create DTOs however for
 *         attributes that do not relate directly to an entity or is an
 *         aggregate of some entities, an example of that could be the data that
 *         is sent for the charts on the dashboard.
 * 
 */
public class Views {
	public static class ListView {
	}

	public static class DetailsView extends ListView {
	}

	public static class InternalView extends DetailsView {
	}
}
