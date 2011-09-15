package org.bimserver.interfaces;

import org.bimserver.interfaces.objects.*;
import java.util.*;
import org.bimserver.models.log.*;
import org.bimserver.models.store.*;
import org.bimserver.database.BimDatabaseSession;

public class SConverter {

	public Set<SLogAction> convertToSSetLogAction(Collection<LogAction> input) {
		Set<SLogAction> result = new HashSet<SLogAction>();
		for (LogAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<LogAction> convertFromSSetLogAction(Collection<SLogAction> input, BimDatabaseSession session) {
		Set<LogAction> result = new HashSet<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SLogAction> convertToSListLogAction(Collection<LogAction> input) {
		List<SLogAction> result = new ArrayList<SLogAction>();
		for (LogAction o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<LogAction> convertFromSListLogAction(Collection<SLogAction> input, BimDatabaseSession session) {
		List<LogAction> result = new ArrayList<LogAction>();
		for (SLogAction o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SLogAction convertToSObject(LogAction input) {
		if (input == null) {
			return null;
		}
		SLogAction result = new SLogAction();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public LogAction convertFromSObject(SLogAction input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		LogAction result = LogFactory.eINSTANCE.createLogAction();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		return result;
	}

	public Set<SServerLog> convertToSSetServerLog(Collection<ServerLog> input) {
		Set<SServerLog> result = new HashSet<SServerLog>();
		for (ServerLog o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerLog> convertFromSSetServerLog(Collection<SServerLog> input, BimDatabaseSession session) {
		Set<ServerLog> result = new HashSet<ServerLog>();
		for (SServerLog o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerLog> convertToSListServerLog(Collection<ServerLog> input) {
		List<SServerLog> result = new ArrayList<SServerLog>();
		for (ServerLog o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerLog> convertFromSListServerLog(Collection<SServerLog> input, BimDatabaseSession session) {
		List<ServerLog> result = new ArrayList<ServerLog>();
		for (SServerLog o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerLog convertToSObject(ServerLog input) {
		if (input == null) {
			return null;
		}
		SServerLog result = new SServerLog();
		result.setOid(input.getOid());
		List<Long> listactions = new ArrayList<Long>();
		for (LogAction v : input.getActions()) {
			listactions.add(v.getOid());
		}
		result.setActions(listactions);
		return result;
	}

	public ServerLog convertFromSObject(SServerLog input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ServerLog result = LogFactory.eINSTANCE.createServerLog();
		result.setOid(input.getOid());
		List<LogAction> listactions = result.getActions();
		for (long oid : input.getActions()) {
			listactions.add((LogAction)session.get(LogPackage.eINSTANCE.getLogAction(), oid, false));
		}
		return result;
	}

	public Set<SNewUserAdded> convertToSSetNewUserAdded(Collection<NewUserAdded> input) {
		Set<SNewUserAdded> result = new HashSet<SNewUserAdded>();
		for (NewUserAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewUserAdded> convertFromSSetNewUserAdded(Collection<SNewUserAdded> input, BimDatabaseSession session) {
		Set<NewUserAdded> result = new HashSet<NewUserAdded>();
		for (SNewUserAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewUserAdded> convertToSListNewUserAdded(Collection<NewUserAdded> input) {
		List<SNewUserAdded> result = new ArrayList<SNewUserAdded>();
		for (NewUserAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewUserAdded> convertFromSListNewUserAdded(Collection<SNewUserAdded> input, BimDatabaseSession session) {
		List<NewUserAdded> result = new ArrayList<NewUserAdded>();
		for (SNewUserAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewUserAdded convertToSObject(NewUserAdded input) {
		if (input == null) {
			return null;
		}
		SNewUserAdded result = new SNewUserAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public NewUserAdded convertFromSObject(SNewUserAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewUserAdded result = LogFactory.eINSTANCE.createNewUserAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		return result;
	}

	public Set<SNewProjectAdded> convertToSSetNewProjectAdded(Collection<NewProjectAdded> input) {
		Set<SNewProjectAdded> result = new HashSet<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewProjectAdded> convertFromSSetNewProjectAdded(Collection<SNewProjectAdded> input, BimDatabaseSession session) {
		Set<NewProjectAdded> result = new HashSet<NewProjectAdded>();
		for (SNewProjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewProjectAdded> convertToSListNewProjectAdded(Collection<NewProjectAdded> input) {
		List<SNewProjectAdded> result = new ArrayList<SNewProjectAdded>();
		for (NewProjectAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewProjectAdded> convertFromSListNewProjectAdded(Collection<SNewProjectAdded> input, BimDatabaseSession session) {
		List<NewProjectAdded> result = new ArrayList<NewProjectAdded>();
		for (SNewProjectAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewProjectAdded convertToSObject(NewProjectAdded input) {
		if (input == null) {
			return null;
		}
		SNewProjectAdded result = new SNewProjectAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Project parentProjectVal = input.getParentProject();
		result.setParentProjectId(parentProjectVal == null ? -1 : parentProjectVal.getOid());
		return result;
	}

	public NewProjectAdded convertFromSObject(SNewProjectAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewProjectAdded result = LogFactory.eINSTANCE.createNewProjectAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		result.setParentProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentProjectId(), false));
		return result;
	}

	public Set<SNewRevisionAdded> convertToSSetNewRevisionAdded(Collection<NewRevisionAdded> input) {
		Set<SNewRevisionAdded> result = new HashSet<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewRevisionAdded> convertFromSSetNewRevisionAdded(Collection<SNewRevisionAdded> input, BimDatabaseSession session) {
		Set<NewRevisionAdded> result = new HashSet<NewRevisionAdded>();
		for (SNewRevisionAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewRevisionAdded> convertToSListNewRevisionAdded(Collection<NewRevisionAdded> input) {
		List<SNewRevisionAdded> result = new ArrayList<SNewRevisionAdded>();
		for (NewRevisionAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewRevisionAdded> convertFromSListNewRevisionAdded(Collection<SNewRevisionAdded> input, BimDatabaseSession session) {
		List<NewRevisionAdded> result = new ArrayList<NewRevisionAdded>();
		for (SNewRevisionAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewRevisionAdded convertToSObject(NewRevisionAdded input) {
		if (input == null) {
			return null;
		}
		SNewRevisionAdded result = new SNewRevisionAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public NewRevisionAdded convertFromSObject(SNewRevisionAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewRevisionAdded result = LogFactory.eINSTANCE.createNewRevisionAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false));
		return result;
	}

	public Set<SNewCheckoutAdded> convertToSSetNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		Set<SNewCheckoutAdded> result = new HashSet<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewCheckoutAdded> convertFromSSetNewCheckoutAdded(Collection<SNewCheckoutAdded> input, BimDatabaseSession session) {
		Set<NewCheckoutAdded> result = new HashSet<NewCheckoutAdded>();
		for (SNewCheckoutAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewCheckoutAdded> convertToSListNewCheckoutAdded(Collection<NewCheckoutAdded> input) {
		List<SNewCheckoutAdded> result = new ArrayList<SNewCheckoutAdded>();
		for (NewCheckoutAdded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewCheckoutAdded> convertFromSListNewCheckoutAdded(Collection<SNewCheckoutAdded> input, BimDatabaseSession session) {
		List<NewCheckoutAdded> result = new ArrayList<NewCheckoutAdded>();
		for (SNewCheckoutAdded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewCheckoutAdded convertToSObject(NewCheckoutAdded input) {
		if (input == null) {
			return null;
		}
		SNewCheckoutAdded result = new SNewCheckoutAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Checkout checkoutVal = input.getCheckout();
		result.setCheckoutId(checkoutVal == null ? -1 : checkoutVal.getOid());
		return result;
	}

	public NewCheckoutAdded convertFromSObject(SNewCheckoutAdded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewCheckoutAdded result = LogFactory.eINSTANCE.createNewCheckoutAdded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setCheckout((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), input.getCheckoutId(), false));
		return result;
	}

	public Set<SSettingsSaved> convertToSSetSettingsSaved(Collection<SettingsSaved> input) {
		Set<SSettingsSaved> result = new HashSet<SSettingsSaved>();
		for (SettingsSaved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<SettingsSaved> convertFromSSetSettingsSaved(Collection<SSettingsSaved> input, BimDatabaseSession session) {
		Set<SettingsSaved> result = new HashSet<SettingsSaved>();
		for (SSettingsSaved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSettingsSaved> convertToSListSettingsSaved(Collection<SettingsSaved> input) {
		List<SSettingsSaved> result = new ArrayList<SSettingsSaved>();
		for (SettingsSaved o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<SettingsSaved> convertFromSListSettingsSaved(Collection<SSettingsSaved> input, BimDatabaseSession session) {
		List<SettingsSaved> result = new ArrayList<SettingsSaved>();
		for (SSettingsSaved o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSettingsSaved convertToSObject(SettingsSaved input) {
		if (input == null) {
			return null;
		}
		SSettingsSaved result = new SSettingsSaved();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public SettingsSaved convertFromSObject(SSettingsSaved input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		SettingsSaved result = LogFactory.eINSTANCE.createSettingsSaved();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		return result;
	}

	public Set<SUserAddedToProject> convertToSSetUserAddedToProject(Collection<UserAddedToProject> input) {
		Set<SUserAddedToProject> result = new HashSet<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserAddedToProject> convertFromSSetUserAddedToProject(Collection<SUserAddedToProject> input, BimDatabaseSession session) {
		Set<UserAddedToProject> result = new HashSet<UserAddedToProject>();
		for (SUserAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserAddedToProject> convertToSListUserAddedToProject(Collection<UserAddedToProject> input) {
		List<SUserAddedToProject> result = new ArrayList<SUserAddedToProject>();
		for (UserAddedToProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserAddedToProject> convertFromSListUserAddedToProject(Collection<SUserAddedToProject> input, BimDatabaseSession session) {
		List<UserAddedToProject> result = new ArrayList<UserAddedToProject>();
		for (SUserAddedToProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserAddedToProject convertToSObject(UserAddedToProject input) {
		if (input == null) {
			return null;
		}
		SUserAddedToProject result = new SUserAddedToProject();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public UserAddedToProject convertFromSObject(SUserAddedToProject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserAddedToProject result = LogFactory.eINSTANCE.createUserAddedToProject();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		return result;
	}

	public Set<SNewGuidanceProviderUploaded> convertToSSetNewGuidanceProviderUploaded(Collection<NewGuidanceProviderUploaded> input) {
		Set<SNewGuidanceProviderUploaded> result = new HashSet<SNewGuidanceProviderUploaded>();
		for (NewGuidanceProviderUploaded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<NewGuidanceProviderUploaded> convertFromSSetNewGuidanceProviderUploaded(Collection<SNewGuidanceProviderUploaded> input, BimDatabaseSession session) {
		Set<NewGuidanceProviderUploaded> result = new HashSet<NewGuidanceProviderUploaded>();
		for (SNewGuidanceProviderUploaded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SNewGuidanceProviderUploaded> convertToSListNewGuidanceProviderUploaded(Collection<NewGuidanceProviderUploaded> input) {
		List<SNewGuidanceProviderUploaded> result = new ArrayList<SNewGuidanceProviderUploaded>();
		for (NewGuidanceProviderUploaded o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<NewGuidanceProviderUploaded> convertFromSListNewGuidanceProviderUploaded(Collection<SNewGuidanceProviderUploaded> input, BimDatabaseSession session) {
		List<NewGuidanceProviderUploaded> result = new ArrayList<NewGuidanceProviderUploaded>();
		for (SNewGuidanceProviderUploaded o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SNewGuidanceProviderUploaded convertToSObject(NewGuidanceProviderUploaded input) {
		if (input == null) {
			return null;
		}
		SNewGuidanceProviderUploaded result = new SNewGuidanceProviderUploaded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public NewGuidanceProviderUploaded convertFromSObject(SNewGuidanceProviderUploaded input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		NewGuidanceProviderUploaded result = LogFactory.eINSTANCE.createNewGuidanceProviderUploaded();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		return result;
	}

	public Set<SDownload> convertToSSetDownload(Collection<Download> input) {
		Set<SDownload> result = new HashSet<SDownload>();
		for (Download o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Download> convertFromSSetDownload(Collection<SDownload> input, BimDatabaseSession session) {
		Set<Download> result = new HashSet<Download>();
		for (SDownload o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDownload> convertToSListDownload(Collection<Download> input) {
		List<SDownload> result = new ArrayList<SDownload>();
		for (Download o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Download> convertFromSListDownload(Collection<SDownload> input, BimDatabaseSession session) {
		List<Download> result = new ArrayList<Download>();
		for (SDownload o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDownload convertToSObject(Download input) {
		if (input == null) {
			return null;
		}
		SDownload result = new SDownload();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public Download convertFromSObject(SDownload input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Download result = LogFactory.eINSTANCE.createDownload();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		return result;
	}

	public Set<SUserRemovedFromProject> convertToSSetUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		Set<SUserRemovedFromProject> result = new HashSet<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserRemovedFromProject> convertFromSSetUserRemovedFromProject(Collection<SUserRemovedFromProject> input, BimDatabaseSession session) {
		Set<UserRemovedFromProject> result = new HashSet<UserRemovedFromProject>();
		for (SUserRemovedFromProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserRemovedFromProject> convertToSListUserRemovedFromProject(Collection<UserRemovedFromProject> input) {
		List<SUserRemovedFromProject> result = new ArrayList<SUserRemovedFromProject>();
		for (UserRemovedFromProject o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserRemovedFromProject> convertFromSListUserRemovedFromProject(Collection<SUserRemovedFromProject> input, BimDatabaseSession session) {
		List<UserRemovedFromProject> result = new ArrayList<UserRemovedFromProject>();
		for (SUserRemovedFromProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserRemovedFromProject convertToSObject(UserRemovedFromProject input) {
		if (input == null) {
			return null;
		}
		SUserRemovedFromProject result = new SUserRemovedFromProject();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public UserRemovedFromProject convertFromSObject(SUserRemovedFromProject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserRemovedFromProject result = LogFactory.eINSTANCE.createUserRemovedFromProject();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		return result;
	}

	public Set<SProjectDeleted> convertToSSetProjectDeleted(Collection<ProjectDeleted> input) {
		Set<SProjectDeleted> result = new HashSet<SProjectDeleted>();
		for (ProjectDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectDeleted> convertFromSSetProjectDeleted(Collection<SProjectDeleted> input, BimDatabaseSession session) {
		Set<ProjectDeleted> result = new HashSet<ProjectDeleted>();
		for (SProjectDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectDeleted> convertToSListProjectDeleted(Collection<ProjectDeleted> input) {
		List<SProjectDeleted> result = new ArrayList<SProjectDeleted>();
		for (ProjectDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectDeleted> convertFromSListProjectDeleted(Collection<SProjectDeleted> input, BimDatabaseSession session) {
		List<ProjectDeleted> result = new ArrayList<ProjectDeleted>();
		for (SProjectDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectDeleted convertToSObject(ProjectDeleted input) {
		if (input == null) {
			return null;
		}
		SProjectDeleted result = new SProjectDeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectDeleted convertFromSObject(SProjectDeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ProjectDeleted result = LogFactory.eINSTANCE.createProjectDeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		return result;
	}

	public Set<SUserDeleted> convertToSSetUserDeleted(Collection<UserDeleted> input) {
		Set<SUserDeleted> result = new HashSet<SUserDeleted>();
		for (UserDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserDeleted> convertFromSSetUserDeleted(Collection<SUserDeleted> input, BimDatabaseSession session) {
		Set<UserDeleted> result = new HashSet<UserDeleted>();
		for (SUserDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserDeleted> convertToSListUserDeleted(Collection<UserDeleted> input) {
		List<SUserDeleted> result = new ArrayList<SUserDeleted>();
		for (UserDeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserDeleted> convertFromSListUserDeleted(Collection<SUserDeleted> input, BimDatabaseSession session) {
		List<UserDeleted> result = new ArrayList<UserDeleted>();
		for (SUserDeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserDeleted convertToSObject(UserDeleted input) {
		if (input == null) {
			return null;
		}
		SUserDeleted result = new SUserDeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserDeleted convertFromSObject(SUserDeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserDeleted result = LogFactory.eINSTANCE.createUserDeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		return result;
	}

	public Set<SPasswordReset> convertToSSetPasswordReset(Collection<PasswordReset> input) {
		Set<SPasswordReset> result = new HashSet<SPasswordReset>();
		for (PasswordReset o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordReset> convertFromSSetPasswordReset(Collection<SPasswordReset> input, BimDatabaseSession session) {
		Set<PasswordReset> result = new HashSet<PasswordReset>();
		for (SPasswordReset o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPasswordReset> convertToSListPasswordReset(Collection<PasswordReset> input) {
		List<SPasswordReset> result = new ArrayList<SPasswordReset>();
		for (PasswordReset o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PasswordReset> convertFromSListPasswordReset(Collection<SPasswordReset> input, BimDatabaseSession session) {
		List<PasswordReset> result = new ArrayList<PasswordReset>();
		for (SPasswordReset o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPasswordReset convertToSObject(PasswordReset input) {
		if (input == null) {
			return null;
		}
		SPasswordReset result = new SPasswordReset();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordReset convertFromSObject(SPasswordReset input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		PasswordReset result = LogFactory.eINSTANCE.createPasswordReset();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		return result;
	}

	public Set<SDatabaseCreated> convertToSSetDatabaseCreated(Collection<DatabaseCreated> input) {
		Set<SDatabaseCreated> result = new HashSet<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<DatabaseCreated> convertFromSSetDatabaseCreated(Collection<SDatabaseCreated> input, BimDatabaseSession session) {
		Set<DatabaseCreated> result = new HashSet<DatabaseCreated>();
		for (SDatabaseCreated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDatabaseCreated> convertToSListDatabaseCreated(Collection<DatabaseCreated> input) {
		List<SDatabaseCreated> result = new ArrayList<SDatabaseCreated>();
		for (DatabaseCreated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<DatabaseCreated> convertFromSListDatabaseCreated(Collection<SDatabaseCreated> input, BimDatabaseSession session) {
		List<DatabaseCreated> result = new ArrayList<DatabaseCreated>();
		for (SDatabaseCreated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDatabaseCreated convertToSObject(DatabaseCreated input) {
		if (input == null) {
			return null;
		}
		SDatabaseCreated result = new SDatabaseCreated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public DatabaseCreated convertFromSObject(SDatabaseCreated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		DatabaseCreated result = LogFactory.eINSTANCE.createDatabaseCreated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setPath(input.getPath());
		result.setVersion(input.getVersion());
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		return result;
	}

	public Set<SServerStarted> convertToSSetServerStarted(Collection<ServerStarted> input) {
		Set<SServerStarted> result = new HashSet<SServerStarted>();
		for (ServerStarted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ServerStarted> convertFromSSetServerStarted(Collection<SServerStarted> input, BimDatabaseSession session) {
		Set<ServerStarted> result = new HashSet<ServerStarted>();
		for (SServerStarted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SServerStarted> convertToSListServerStarted(Collection<ServerStarted> input) {
		List<SServerStarted> result = new ArrayList<SServerStarted>();
		for (ServerStarted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ServerStarted> convertFromSListServerStarted(Collection<SServerStarted> input, BimDatabaseSession session) {
		List<ServerStarted> result = new ArrayList<ServerStarted>();
		for (SServerStarted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SServerStarted convertToSObject(ServerStarted input) {
		if (input == null) {
			return null;
		}
		SServerStarted result = new SServerStarted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		return result;
	}

	public ServerStarted convertFromSObject(SServerStarted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ServerStarted result = LogFactory.eINSTANCE.createServerStarted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		return result;
	}

	public Set<SProjectUpdated> convertToSSetProjectUpdated(Collection<ProjectUpdated> input) {
		Set<SProjectUpdated> result = new HashSet<SProjectUpdated>();
		for (ProjectUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUpdated> convertFromSSetProjectUpdated(Collection<SProjectUpdated> input, BimDatabaseSession session) {
		Set<ProjectUpdated> result = new HashSet<ProjectUpdated>();
		for (SProjectUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectUpdated> convertToSListProjectUpdated(Collection<ProjectUpdated> input) {
		List<SProjectUpdated> result = new ArrayList<SProjectUpdated>();
		for (ProjectUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectUpdated> convertFromSListProjectUpdated(Collection<SProjectUpdated> input, BimDatabaseSession session) {
		List<ProjectUpdated> result = new ArrayList<ProjectUpdated>();
		for (SProjectUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectUpdated convertToSObject(ProjectUpdated input) {
		if (input == null) {
			return null;
		}
		SProjectUpdated result = new SProjectUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUpdated convertFromSObject(SProjectUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ProjectUpdated result = LogFactory.eINSTANCE.createProjectUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		return result;
	}

	public Set<SUserUndeleted> convertToSSetUserUndeleted(Collection<UserUndeleted> input) {
		Set<SUserUndeleted> result = new HashSet<SUserUndeleted>();
		for (UserUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserUndeleted> convertFromSSetUserUndeleted(Collection<SUserUndeleted> input, BimDatabaseSession session) {
		Set<UserUndeleted> result = new HashSet<UserUndeleted>();
		for (SUserUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserUndeleted> convertToSListUserUndeleted(Collection<UserUndeleted> input) {
		List<SUserUndeleted> result = new ArrayList<SUserUndeleted>();
		for (UserUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserUndeleted> convertFromSListUserUndeleted(Collection<SUserUndeleted> input, BimDatabaseSession session) {
		List<UserUndeleted> result = new ArrayList<UserUndeleted>();
		for (SUserUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserUndeleted convertToSObject(UserUndeleted input) {
		if (input == null) {
			return null;
		}
		SUserUndeleted result = new SUserUndeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserUndeleted convertFromSObject(SUserUndeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserUndeleted result = LogFactory.eINSTANCE.createUserUndeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		return result;
	}

	public Set<SProjectUndeleted> convertToSSetProjectUndeleted(Collection<ProjectUndeleted> input) {
		Set<SProjectUndeleted> result = new HashSet<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ProjectUndeleted> convertFromSSetProjectUndeleted(Collection<SProjectUndeleted> input, BimDatabaseSession session) {
		Set<ProjectUndeleted> result = new HashSet<ProjectUndeleted>();
		for (SProjectUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProjectUndeleted> convertToSListProjectUndeleted(Collection<ProjectUndeleted> input) {
		List<SProjectUndeleted> result = new ArrayList<SProjectUndeleted>();
		for (ProjectUndeleted o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ProjectUndeleted> convertFromSListProjectUndeleted(Collection<SProjectUndeleted> input, BimDatabaseSession session) {
		List<ProjectUndeleted> result = new ArrayList<ProjectUndeleted>();
		for (SProjectUndeleted o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProjectUndeleted convertToSObject(ProjectUndeleted input) {
		if (input == null) {
			return null;
		}
		SProjectUndeleted result = new SProjectUndeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		return result;
	}

	public ProjectUndeleted convertFromSObject(SProjectUndeleted input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ProjectUndeleted result = LogFactory.eINSTANCE.createProjectUndeleted();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		return result;
	}

	public Set<SRevisionUpdated> convertToSSetRevisionUpdated(Collection<RevisionUpdated> input) {
		Set<SRevisionUpdated> result = new HashSet<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<RevisionUpdated> convertFromSSetRevisionUpdated(Collection<SRevisionUpdated> input, BimDatabaseSession session) {
		Set<RevisionUpdated> result = new HashSet<RevisionUpdated>();
		for (SRevisionUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevisionUpdated> convertToSListRevisionUpdated(Collection<RevisionUpdated> input) {
		List<SRevisionUpdated> result = new ArrayList<SRevisionUpdated>();
		for (RevisionUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<RevisionUpdated> convertFromSListRevisionUpdated(Collection<SRevisionUpdated> input, BimDatabaseSession session) {
		List<RevisionUpdated> result = new ArrayList<RevisionUpdated>();
		for (SRevisionUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevisionUpdated convertToSObject(RevisionUpdated input) {
		if (input == null) {
			return null;
		}
		SRevisionUpdated result = new SRevisionUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		return result;
	}

	public RevisionUpdated convertFromSObject(SRevisionUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		RevisionUpdated result = LogFactory.eINSTANCE.createRevisionUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false));
		return result;
	}

	public Set<SGeoTagUpdated> convertToSSetGeoTagUpdated(Collection<GeoTagUpdated> input) {
		Set<SGeoTagUpdated> result = new HashSet<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTagUpdated> convertFromSSetGeoTagUpdated(Collection<SGeoTagUpdated> input, BimDatabaseSession session) {
		Set<GeoTagUpdated> result = new HashSet<GeoTagUpdated>();
		for (SGeoTagUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeoTagUpdated> convertToSListGeoTagUpdated(Collection<GeoTagUpdated> input) {
		List<SGeoTagUpdated> result = new ArrayList<SGeoTagUpdated>();
		for (GeoTagUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeoTagUpdated> convertFromSListGeoTagUpdated(Collection<SGeoTagUpdated> input, BimDatabaseSession session) {
		List<GeoTagUpdated> result = new ArrayList<GeoTagUpdated>();
		for (SGeoTagUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeoTagUpdated convertToSObject(GeoTagUpdated input) {
		if (input == null) {
			return null;
		}
		SGeoTagUpdated result = new SGeoTagUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		return result;
	}

	public GeoTagUpdated convertFromSObject(SGeoTagUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GeoTagUpdated result = LogFactory.eINSTANCE.createGeoTagUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), false));
		return result;
	}

	public Set<SClashDetectionSettingsUpdated> convertToSSetClashDetectionSettingsUpdated(Collection<ClashDetectionSettingsUpdated> input) {
		Set<SClashDetectionSettingsUpdated> result = new HashSet<SClashDetectionSettingsUpdated>();
		for (ClashDetectionSettingsUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ClashDetectionSettingsUpdated> convertFromSSetClashDetectionSettingsUpdated(Collection<SClashDetectionSettingsUpdated> input, BimDatabaseSession session) {
		Set<ClashDetectionSettingsUpdated> result = new HashSet<ClashDetectionSettingsUpdated>();
		for (SClashDetectionSettingsUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SClashDetectionSettingsUpdated> convertToSListClashDetectionSettingsUpdated(Collection<ClashDetectionSettingsUpdated> input) {
		List<SClashDetectionSettingsUpdated> result = new ArrayList<SClashDetectionSettingsUpdated>();
		for (ClashDetectionSettingsUpdated o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ClashDetectionSettingsUpdated> convertFromSListClashDetectionSettingsUpdated(Collection<SClashDetectionSettingsUpdated> input, BimDatabaseSession session) {
		List<ClashDetectionSettingsUpdated> result = new ArrayList<ClashDetectionSettingsUpdated>();
		for (SClashDetectionSettingsUpdated o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SClashDetectionSettingsUpdated convertToSObject(ClashDetectionSettingsUpdated input) {
		if (input == null) {
			return null;
		}
		SClashDetectionSettingsUpdated result = new SClashDetectionSettingsUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		ClashDetectionSettings clashDetectionSettingsVal = input.getClashDetectionSettings();
		result.setClashDetectionSettingsId(clashDetectionSettingsVal == null ? -1 : clashDetectionSettingsVal.getOid());
		return result;
	}

	public ClashDetectionSettingsUpdated convertFromSObject(SClashDetectionSettingsUpdated input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ClashDetectionSettingsUpdated result = LogFactory.eINSTANCE.createClashDetectionSettingsUpdated();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setClashDetectionSettings((ClashDetectionSettings)session.get(StorePackage.eINSTANCE.getClashDetectionSettings(), input.getClashDetectionSettingsId(), false));
		return result;
	}

	public Set<SPasswordChanged> convertToSSetPasswordChanged(Collection<PasswordChanged> input) {
		Set<SPasswordChanged> result = new HashSet<SPasswordChanged>();
		for (PasswordChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<PasswordChanged> convertFromSSetPasswordChanged(Collection<SPasswordChanged> input, BimDatabaseSession session) {
		Set<PasswordChanged> result = new HashSet<PasswordChanged>();
		for (SPasswordChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPasswordChanged> convertToSListPasswordChanged(Collection<PasswordChanged> input) {
		List<SPasswordChanged> result = new ArrayList<SPasswordChanged>();
		for (PasswordChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<PasswordChanged> convertFromSListPasswordChanged(Collection<SPasswordChanged> input, BimDatabaseSession session) {
		List<PasswordChanged> result = new ArrayList<PasswordChanged>();
		for (SPasswordChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPasswordChanged convertToSObject(PasswordChanged input) {
		if (input == null) {
			return null;
		}
		SPasswordChanged result = new SPasswordChanged();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public PasswordChanged convertFromSObject(SPasswordChanged input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		PasswordChanged result = LogFactory.eINSTANCE.createPasswordChanged();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		return result;
	}

	public Set<SUserChanged> convertToSSetUserChanged(Collection<UserChanged> input) {
		Set<SUserChanged> result = new HashSet<SUserChanged>();
		for (UserChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<UserChanged> convertFromSSetUserChanged(Collection<SUserChanged> input, BimDatabaseSession session) {
		Set<UserChanged> result = new HashSet<UserChanged>();
		for (SUserChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUserChanged> convertToSListUserChanged(Collection<UserChanged> input) {
		List<SUserChanged> result = new ArrayList<SUserChanged>();
		for (UserChanged o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<UserChanged> convertFromSListUserChanged(Collection<SUserChanged> input, BimDatabaseSession session) {
		List<UserChanged> result = new ArrayList<UserChanged>();
		for (SUserChanged o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUserChanged convertToSObject(UserChanged input) {
		if (input == null) {
			return null;
		}
		SUserChanged result = new SUserChanged();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(SAccessMethod.values()[input.getAccessMethod().ordinal()]);
		User executorVal = input.getExecutor();
		result.setExecutorId(executorVal == null ? -1 : executorVal.getOid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		return result;
	}

	public UserChanged convertFromSObject(SUserChanged input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		UserChanged result = LogFactory.eINSTANCE.createUserChanged();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setAccessMethod(AccessMethod.values()[input.getAccessMethod().ordinal()]);
		result.setExecutor((User)session.get(StorePackage.eINSTANCE.getUser(), input.getExecutorId(), false));
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		return result;
	}
		public SAccessMethod convertToSObject(AccessMethod input) {
			return SAccessMethod.values()[input.ordinal()];
		}
		
		public AccessMethod convertFromSObject(SAccessMethod input) {
			return AccessMethod.values()[input.ordinal()];
		}

	public Set<SProject> convertToSSetProject(Collection<Project> input) {
		Set<SProject> result = new HashSet<SProject>();
		for (Project o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Project> convertFromSSetProject(Collection<SProject> input, BimDatabaseSession session) {
		Set<Project> result = new HashSet<Project>();
		for (SProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SProject> convertToSListProject(Collection<Project> input) {
		List<SProject> result = new ArrayList<SProject>();
		for (Project o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Project> convertFromSListProject(Collection<SProject> input, BimDatabaseSession session) {
		List<Project> result = new ArrayList<Project>();
		for (SProject o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SProject convertToSObject(Project input) {
		if (input == null) {
			return null;
		}
		SProject result = new SProject();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SSIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		List<Long> listhasAuthorizedUsers = new ArrayList<Long>();
		for (User v : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add(v.getOid());
		}
		result.setHasAuthorizedUsers(listhasAuthorizedUsers);
		List<Long> listconcreteRevisions = new ArrayList<Long>();
		for (ConcreteRevision v : input.getConcreteRevisions()) {
			listconcreteRevisions.add(v.getOid());
		}
		result.setConcreteRevisions(listconcreteRevisions);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		ConcreteRevision lastConcreteRevisionVal = input.getLastConcreteRevision();
		result.setLastConcreteRevisionId(lastConcreteRevisionVal == null ? -1 : lastConcreteRevisionVal.getOid());
		Revision lastRevisionVal = input.getLastRevision();
		result.setLastRevisionId(lastRevisionVal == null ? -1 : lastRevisionVal.getOid());
		List<Long> listcheckouts = new ArrayList<Long>();
		for (Checkout v : input.getCheckouts()) {
			listcheckouts.add(v.getOid());
		}
		result.setCheckouts(listcheckouts);
		User createdByVal = input.getCreatedBy();
		result.setCreatedById(createdByVal == null ? -1 : createdByVal.getOid());
		GeoTag geoTagVal = input.getGeoTag();
		result.setGeoTagId(geoTagVal == null ? -1 : geoTagVal.getOid());
		List<Long> listsubProjects = new ArrayList<Long>();
		for (Project v : input.getSubProjects()) {
			listsubProjects.add(v.getOid());
		}
		result.setSubProjects(listsubProjects);
		Project parentVal = input.getParent();
		result.setParentId(parentVal == null ? -1 : parentVal.getOid());
		ClashDetectionSettings clashDetectionSettingsVal = input.getClashDetectionSettings();
		result.setClashDetectionSettingsId(clashDetectionSettingsVal == null ? -1 : clashDetectionSettingsVal.getOid());
		return result;
	}

	public Project convertFromSObject(SProject input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Project result = StoreFactory.eINSTANCE.createProject();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setName(input.getName());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedDate(input.getCreatedDate());
		result.setDescription(input.getDescription());
		result.setExportLengthMeasurePrefix(SIPrefix.values()[input.getExportLengthMeasurePrefix().ordinal()]);
		List<User> listhasAuthorizedUsers = result.getHasAuthorizedUsers();
		for (long oid : input.getHasAuthorizedUsers()) {
			listhasAuthorizedUsers.add((User)session.get(StorePackage.eINSTANCE.getUser(), oid, false));
		}
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, false));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), false));
		result.setLastRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getLastRevisionId(), false));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, false));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), false));
		result.setGeoTag((GeoTag)session.get(StorePackage.eINSTANCE.getGeoTag(), input.getGeoTagId(), false));
		List<Project> listsubProjects = result.getSubProjects();
		for (long oid : input.getSubProjects()) {
			listsubProjects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false));
		}
		result.setParent((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getParentId(), false));
		result.setClashDetectionSettings((ClashDetectionSettings)session.get(StorePackage.eINSTANCE.getClashDetectionSettings(), input.getClashDetectionSettingsId(), false));
		return result;
	}

	public Set<SUser> convertToSSetUser(Collection<User> input) {
		Set<SUser> result = new HashSet<SUser>();
		for (User o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<User> convertFromSSetUser(Collection<SUser> input, BimDatabaseSession session) {
		Set<User> result = new HashSet<User>();
		for (SUser o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SUser> convertToSListUser(Collection<User> input) {
		List<SUser> result = new ArrayList<SUser>();
		for (User o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<User> convertFromSListUser(Collection<SUser> input, BimDatabaseSession session) {
		List<User> result = new ArrayList<User>();
		for (SUser o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SUser convertToSObject(User input) {
		if (input == null) {
			return null;
		}
		SUser result = new SUser();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(SObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(SUserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		result.setNotificationUrl(input.getNotificationUrl());
		List<Long> listhasRightsOn = new ArrayList<Long>();
		for (Project v : input.getHasRightsOn()) {
			listhasRightsOn.add(v.getOid());
		}
		result.setHasRightsOn(listhasRightsOn);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		User createdByVal = input.getCreatedBy();
		result.setCreatedById(createdByVal == null ? -1 : createdByVal.getOid());
		return result;
	}

	public User convertFromSObject(SUser input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		User result = StoreFactory.eINSTANCE.createUser();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setPassword(input.getPassword());
		result.setState(ObjectState.values()[input.getState().ordinal()]);
		result.setCreatedOn(input.getCreatedOn());
		result.setUserType(UserType.values()[input.getUserType().ordinal()]);
		result.setUsername(input.getUsername());
		result.setLastSeen(input.getLastSeen());
		result.setValidationToken(input.getValidationToken());
		result.setValidationTokenCreated(input.getValidationTokenCreated());
		result.setNotificationUrl(input.getNotificationUrl());
		List<Project> listhasRightsOn = result.getHasRightsOn();
		for (long oid : input.getHasRightsOn()) {
			listhasRightsOn.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false));
		}
		result.setCreatedBy((User)session.get(StorePackage.eINSTANCE.getUser(), input.getCreatedById(), false));
		return result;
	}

	public Set<SClash> convertToSSetClash(Collection<Clash> input) {
		Set<SClash> result = new HashSet<SClash>();
		for (Clash o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Clash> convertFromSSetClash(Collection<SClash> input, BimDatabaseSession session) {
		Set<Clash> result = new HashSet<Clash>();
		for (SClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SClash> convertToSListClash(Collection<Clash> input) {
		List<SClash> result = new ArrayList<SClash>();
		for (Clash o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Clash> convertFromSListClash(Collection<SClash> input, BimDatabaseSession session) {
		List<Clash> result = new ArrayList<Clash>();
		for (SClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SClash convertToSObject(Clash input) {
		if (input == null) {
			return null;
		}
		SClash result = new SClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		Revision revision1Val = input.getRevision1();
		result.setRevision1Id(revision1Val == null ? -1 : revision1Val.getOid());
		Revision revision2Val = input.getRevision2();
		result.setRevision2Id(revision2Val == null ? -1 : revision2Val.getOid());
		return result;
	}

	public Clash convertFromSObject(SClash input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Clash result = StoreFactory.eINSTANCE.createClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setRevision1((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision1Id(), false));
		result.setRevision2((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision2Id(), false));
		return result;
	}

	public Set<SEidClash> convertToSSetEidClash(Collection<EidClash> input) {
		Set<SEidClash> result = new HashSet<SEidClash>();
		for (EidClash o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<EidClash> convertFromSSetEidClash(Collection<SEidClash> input, BimDatabaseSession session) {
		Set<EidClash> result = new HashSet<EidClash>();
		for (SEidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SEidClash> convertToSListEidClash(Collection<EidClash> input) {
		List<SEidClash> result = new ArrayList<SEidClash>();
		for (EidClash o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<EidClash> convertFromSListEidClash(Collection<SEidClash> input, BimDatabaseSession session) {
		List<EidClash> result = new ArrayList<EidClash>();
		for (SEidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SEidClash convertToSObject(EidClash input) {
		if (input == null) {
			return null;
		}
		SEidClash result = new SEidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setEid1(input.getEid1());
		result.setEid2(input.getEid2());
		Revision revision1Val = input.getRevision1();
		result.setRevision1Id(revision1Val == null ? -1 : revision1Val.getOid());
		Revision revision2Val = input.getRevision2();
		result.setRevision2Id(revision2Val == null ? -1 : revision2Val.getOid());
		return result;
	}

	public EidClash convertFromSObject(SEidClash input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		EidClash result = StoreFactory.eINSTANCE.createEidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setEid1(input.getEid1());
		result.setEid2(input.getEid2());
		result.setRevision1((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision1Id(), false));
		result.setRevision2((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision2Id(), false));
		return result;
	}

	public Set<SGuidClash> convertToSSetGuidClash(Collection<GuidClash> input) {
		Set<SGuidClash> result = new HashSet<SGuidClash>();
		for (GuidClash o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GuidClash> convertFromSSetGuidClash(Collection<SGuidClash> input, BimDatabaseSession session) {
		Set<GuidClash> result = new HashSet<GuidClash>();
		for (SGuidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGuidClash> convertToSListGuidClash(Collection<GuidClash> input) {
		List<SGuidClash> result = new ArrayList<SGuidClash>();
		for (GuidClash o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GuidClash> convertFromSListGuidClash(Collection<SGuidClash> input, BimDatabaseSession session) {
		List<GuidClash> result = new ArrayList<GuidClash>();
		for (SGuidClash o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGuidClash convertToSObject(GuidClash input) {
		if (input == null) {
			return null;
		}
		SGuidClash result = new SGuidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setGuid1(input.getGuid1());
		result.setGuid2(input.getGuid2());
		Revision revision1Val = input.getRevision1();
		result.setRevision1Id(revision1Val == null ? -1 : revision1Val.getOid());
		Revision revision2Val = input.getRevision2();
		result.setRevision2Id(revision2Val == null ? -1 : revision2Val.getOid());
		return result;
	}

	public GuidClash convertFromSObject(SGuidClash input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GuidClash result = StoreFactory.eINSTANCE.createGuidClash();
		result.setOid(input.getOid());
		result.setName1(input.getName1());
		result.setName2(input.getName2());
		result.setType1(input.getType1());
		result.setType2(input.getType2());
		result.setGuid1(input.getGuid1());
		result.setGuid2(input.getGuid2());
		result.setRevision1((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision1Id(), false));
		result.setRevision2((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevision2Id(), false));
		return result;
	}

	public Set<SClashDetectionSettings> convertToSSetClashDetectionSettings(Collection<ClashDetectionSettings> input) {
		Set<SClashDetectionSettings> result = new HashSet<SClashDetectionSettings>();
		for (ClashDetectionSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ClashDetectionSettings> convertFromSSetClashDetectionSettings(Collection<SClashDetectionSettings> input, BimDatabaseSession session) {
		Set<ClashDetectionSettings> result = new HashSet<ClashDetectionSettings>();
		for (SClashDetectionSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SClashDetectionSettings> convertToSListClashDetectionSettings(Collection<ClashDetectionSettings> input) {
		List<SClashDetectionSettings> result = new ArrayList<SClashDetectionSettings>();
		for (ClashDetectionSettings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ClashDetectionSettings> convertFromSListClashDetectionSettings(Collection<SClashDetectionSettings> input, BimDatabaseSession session) {
		List<ClashDetectionSettings> result = new ArrayList<ClashDetectionSettings>();
		for (SClashDetectionSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SClashDetectionSettings convertToSObject(ClashDetectionSettings input) {
		if (input == null) {
			return null;
		}
		SClashDetectionSettings result = new SClashDetectionSettings();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setMargin(input.getMargin());
		result.setIgnoredClasses(input.getIgnoredClasses());
		List<Long> listprojects = new ArrayList<Long>();
		for (Project v : input.getProjects()) {
			listprojects.add(v.getOid());
		}
		result.setProjects(listprojects);
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		return result;
	}

	public ClashDetectionSettings convertFromSObject(SClashDetectionSettings input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ClashDetectionSettings result = StoreFactory.eINSTANCE.createClashDetectionSettings();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setMargin(input.getMargin());
		List<Project> listprojects = result.getProjects();
		for (long oid : input.getProjects()) {
			listprojects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false));
		}
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false));
		}
		return result;
	}

	public Set<SRevision> convertToSSetRevision(Collection<Revision> input) {
		Set<SRevision> result = new HashSet<SRevision>();
		for (Revision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Revision> convertFromSSetRevision(Collection<SRevision> input, BimDatabaseSession session) {
		Set<Revision> result = new HashSet<Revision>();
		for (SRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SRevision> convertToSListRevision(Collection<Revision> input) {
		List<SRevision> result = new ArrayList<SRevision>();
		for (Revision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Revision> convertFromSListRevision(Collection<SRevision> input, BimDatabaseSession session) {
		List<Revision> result = new ArrayList<Revision>();
		for (SRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SRevision convertToSObject(Revision input) {
		if (input == null) {
			return null;
		}
		SRevision result = new SRevision();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setState(SCheckinState.values()[input.getState().ordinal()]);
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setNrClashes(input.getNrClashes());
		result.setLaid(input.getLaid());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		List<Long> listconcreteRevisions = new ArrayList<Long>();
		for (ConcreteRevision v : input.getConcreteRevisions()) {
			listconcreteRevisions.add(v.getOid());
		}
		result.setConcreteRevisions(listconcreteRevisions);
		ConcreteRevision lastConcreteRevisionVal = input.getLastConcreteRevision();
		result.setLastConcreteRevisionId(lastConcreteRevisionVal == null ? -1 : lastConcreteRevisionVal.getOid());
		List<Long> listcheckouts = new ArrayList<Long>();
		for (Checkout v : input.getCheckouts()) {
			listcheckouts.add(v.getOid());
		}
		result.setCheckouts(listcheckouts);
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listlastClashes = new ArrayList<Long>();
		for (Clash v : input.getLastClashes()) {
			listlastClashes.add(v.getOid());
		}
		result.setLastClashes(listlastClashes);
		return result;
	}

	public Revision convertFromSObject(SRevision input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Revision result = StoreFactory.eINSTANCE.createRevision();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setDate(input.getDate());
		result.setComment(input.getComment());
		result.setSize(input.getSize());
		result.setState(CheckinState.values()[input.getState().ordinal()]);
		result.setTag(input.getTag());
		result.setLastError(input.getLastError());
		result.setBmi(input.getBmi());
		result.setNrClashes(input.getNrClashes());
		result.setLaid(input.getLaid());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		List<ConcreteRevision> listconcreteRevisions = result.getConcreteRevisions();
		for (long oid : input.getConcreteRevisions()) {
			listconcreteRevisions.add((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), oid, false));
		}
		result.setLastConcreteRevision((ConcreteRevision)session.get(StorePackage.eINSTANCE.getConcreteRevision(), input.getLastConcreteRevisionId(), false));
		List<Checkout> listcheckouts = result.getCheckouts();
		for (long oid : input.getCheckouts()) {
			listcheckouts.add((Checkout)session.get(StorePackage.eINSTANCE.getCheckout(), oid, false));
		}
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		List<Clash> listlastClashes = result.getLastClashes();
		for (long oid : input.getLastClashes()) {
			listlastClashes.add((Clash)session.get(StorePackage.eINSTANCE.getClash(), oid, false));
		}
		return result;
	}

	public Set<SConcreteRevision> convertToSSetConcreteRevision(Collection<ConcreteRevision> input) {
		Set<SConcreteRevision> result = new HashSet<SConcreteRevision>();
		for (ConcreteRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<ConcreteRevision> convertFromSSetConcreteRevision(Collection<SConcreteRevision> input, BimDatabaseSession session) {
		Set<ConcreteRevision> result = new HashSet<ConcreteRevision>();
		for (SConcreteRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SConcreteRevision> convertToSListConcreteRevision(Collection<ConcreteRevision> input) {
		List<SConcreteRevision> result = new ArrayList<SConcreteRevision>();
		for (ConcreteRevision o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<ConcreteRevision> convertFromSListConcreteRevision(Collection<SConcreteRevision> input, BimDatabaseSession session) {
		List<ConcreteRevision> result = new ArrayList<ConcreteRevision>();
		for (SConcreteRevision o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SConcreteRevision convertToSObject(ConcreteRevision input) {
		if (input == null) {
			return null;
		}
		SConcreteRevision result = new SConcreteRevision();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setState(SCheckinState.values()[input.getState().ordinal()]);
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		List<Long> listrevisions = new ArrayList<Long>();
		for (Revision v : input.getRevisions()) {
			listrevisions.add(v.getOid());
		}
		result.setRevisions(listrevisions);
		return result;
	}

	public ConcreteRevision convertFromSObject(SConcreteRevision input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		ConcreteRevision result = StoreFactory.eINSTANCE.createConcreteRevision();
		result.setOid(input.getOid());
		result.setId(input.getId());
		result.setState(CheckinState.values()[input.getState().ordinal()]);
		result.setChecksum(input.getChecksum());
		result.setSize(input.getSize());
		result.setDate(input.getDate());
		result.setLastError(input.getLastError());
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		List<Revision> listrevisions = result.getRevisions();
		for (long oid : input.getRevisions()) {
			listrevisions.add((Revision)session.get(StorePackage.eINSTANCE.getRevision(), oid, false));
		}
		return result;
	}

	public Set<SGeoTag> convertToSSetGeoTag(Collection<GeoTag> input) {
		Set<SGeoTag> result = new HashSet<SGeoTag>();
		for (GeoTag o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GeoTag> convertFromSSetGeoTag(Collection<SGeoTag> input, BimDatabaseSession session) {
		Set<GeoTag> result = new HashSet<GeoTag>();
		for (SGeoTag o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGeoTag> convertToSListGeoTag(Collection<GeoTag> input) {
		List<SGeoTag> result = new ArrayList<SGeoTag>();
		for (GeoTag o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GeoTag> convertFromSListGeoTag(Collection<SGeoTag> input, BimDatabaseSession session) {
		List<GeoTag> result = new ArrayList<GeoTag>();
		for (SGeoTag o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGeoTag convertToSObject(GeoTag input) {
		if (input == null) {
			return null;
		}
		SGeoTag result = new SGeoTag();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Long> listprojects = new ArrayList<Long>();
		for (Project v : input.getProjects()) {
			listprojects.add(v.getOid());
		}
		result.setProjects(listprojects);
		return result;
	}

	public GeoTag convertFromSObject(SGeoTag input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GeoTag result = StoreFactory.eINSTANCE.createGeoTag();
		result.setOid(input.getOid());
		result.setEnabled(input.isEnabled());
		result.setX(input.getX());
		result.setY(input.getY());
		result.setZ(input.getZ());
		result.setEpsg(input.getEpsg());
		result.setDirectionAngle(input.getDirectionAngle());
		List<Project> listprojects = result.getProjects();
		for (long oid : input.getProjects()) {
			listprojects.add((Project)session.get(StorePackage.eINSTANCE.getProject(), oid, false));
		}
		return result;
	}

	public Set<SCheckout> convertToSSetCheckout(Collection<Checkout> input) {
		Set<SCheckout> result = new HashSet<SCheckout>();
		for (Checkout o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Checkout> convertFromSSetCheckout(Collection<SCheckout> input, BimDatabaseSession session) {
		Set<Checkout> result = new HashSet<Checkout>();
		for (SCheckout o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SCheckout> convertToSListCheckout(Collection<Checkout> input) {
		List<SCheckout> result = new ArrayList<SCheckout>();
		for (Checkout o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Checkout> convertFromSListCheckout(Collection<SCheckout> input, BimDatabaseSession session) {
		List<Checkout> result = new ArrayList<Checkout>();
		for (SCheckout o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SCheckout convertToSObject(Checkout input) {
		if (input == null) {
			return null;
		}
		SCheckout result = new SCheckout();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setActive(input.isActive());
		User userVal = input.getUser();
		result.setUserId(userVal == null ? -1 : userVal.getOid());
		Revision revisionVal = input.getRevision();
		result.setRevisionId(revisionVal == null ? -1 : revisionVal.getOid());
		Project projectVal = input.getProject();
		result.setProjectId(projectVal == null ? -1 : projectVal.getOid());
		Revision checkinVal = input.getCheckin();
		result.setCheckinId(checkinVal == null ? -1 : checkinVal.getOid());
		return result;
	}

	public Checkout convertFromSObject(SCheckout input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Checkout result = StoreFactory.eINSTANCE.createCheckout();
		result.setOid(input.getOid());
		result.setDate(input.getDate());
		result.setActive(input.isActive());
		result.setUser((User)session.get(StorePackage.eINSTANCE.getUser(), input.getUserId(), false));
		result.setRevision((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getRevisionId(), false));
		result.setProject((Project)session.get(StorePackage.eINSTANCE.getProject(), input.getProjectId(), false));
		result.setCheckin((Revision)session.get(StorePackage.eINSTANCE.getRevision(), input.getCheckinId(), false));
		return result;
	}

	public Set<SSettings> convertToSSetSettings(Collection<Settings> input) {
		Set<SSettings> result = new HashSet<SSettings>();
		for (Settings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Settings> convertFromSSetSettings(Collection<SSettings> input, BimDatabaseSession session) {
		Set<Settings> result = new HashSet<Settings>();
		for (SSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSettings> convertToSListSettings(Collection<Settings> input) {
		List<SSettings> result = new ArrayList<SSettings>();
		for (Settings o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Settings> convertFromSListSettings(Collection<SSettings> input, BimDatabaseSession session) {
		List<Settings> result = new ArrayList<Settings>();
		for (SSettings o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSettings convertToSObject(Settings input) {
		if (input == null) {
			return null;
		}
		SSettings result = new SSettings();
		result.setOid(input.getOid());
		result.setShowVersionUpgradeAvailable(input.isShowVersionUpgradeAvailable());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setUseCaching(input.isUseCaching());
		result.setAllowSelfRegistration(input.isAllowSelfRegistration());
		result.setAutoTestClashes(input.isAutoTestClashes());
		result.setIntelligentMerging(input.isIntelligentMerging());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.isCheckinMergingEnabled());
		result.setRegistrationAddition(input.getRegistrationAddition());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setEnabledExportTypes(input.getEnabledExportTypes());
		result.setCustomLogoAddress(input.getCustomLogoAddress());
		result.setSiteAddress(input.getSiteAddress());
		result.setHeaderAddition(input.getHeaderAddition());
		result.setFooterAddition(input.getFooterAddition());
		result.setMergeIdentifier(SMergeIdentifier.values()[input.getMergeIdentifier().ordinal()]);
		result.setCacheOutputFiles(input.isCacheOutputFiles());
		List<Long> listserializers = new ArrayList<Long>();
		for (Serializer v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		List<Long> listguidanceProviders = new ArrayList<Long>();
		for (GuidanceProvider v : input.getGuidanceProviders()) {
			listguidanceProviders.add(v.getOid());
		}
		result.setGuidanceProviders(listguidanceProviders);
		List<Long> listifcEngines = new ArrayList<Long>();
		for (IfcEngine v : input.getIfcEngines()) {
			listifcEngines.add(v.getOid());
		}
		result.setIfcEngines(listifcEngines);
		List<Long> listplugins = new ArrayList<Long>();
		for (Plugin v : input.getPlugins()) {
			listplugins.add(v.getOid());
		}
		result.setPlugins(listplugins);
		List<Long> listdeserializers = new ArrayList<Long>();
		for (Deserializer v : input.getDeserializers()) {
			listdeserializers.add(v.getOid());
		}
		result.setDeserializers(listdeserializers);
		return result;
	}

	public Settings convertFromSObject(SSettings input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Settings result = StoreFactory.eINSTANCE.createSettings();
		result.setOid(input.getOid());
		result.setShowVersionUpgradeAvailable(input.isShowVersionUpgradeAvailable());
		result.setSendConfirmationEmailAfterRegistration(input.isSendConfirmationEmailAfterRegistration());
		result.setUseCaching(input.isUseCaching());
		result.setAllowSelfRegistration(input.isAllowSelfRegistration());
		result.setAutoTestClashes(input.isAutoTestClashes());
		result.setIntelligentMerging(input.isIntelligentMerging());
		result.setAllowUsersToCreateTopLevelProjects(input.isAllowUsersToCreateTopLevelProjects());
		result.setCheckinMergingEnabled(input.isCheckinMergingEnabled());
		result.setRegistrationAddition(input.getRegistrationAddition());
		result.setSmtpServer(input.getSmtpServer());
		result.setEmailSenderAddress(input.getEmailSenderAddress());
		result.setEnabledExportTypes(input.getEnabledExportTypes());
		result.setCustomLogoAddress(input.getCustomLogoAddress());
		result.setSiteAddress(input.getSiteAddress());
		result.setHeaderAddition(input.getHeaderAddition());
		result.setFooterAddition(input.getFooterAddition());
		result.setMergeIdentifier(MergeIdentifier.values()[input.getMergeIdentifier().ordinal()]);
		result.setCacheOutputFiles(input.isCacheOutputFiles());
		List<Serializer> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), oid, false));
		}
		List<GuidanceProvider> listguidanceProviders = result.getGuidanceProviders();
		for (long oid : input.getGuidanceProviders()) {
			listguidanceProviders.add((GuidanceProvider)session.get(StorePackage.eINSTANCE.getGuidanceProvider(), oid, false));
		}
		List<IfcEngine> listifcEngines = result.getIfcEngines();
		for (long oid : input.getIfcEngines()) {
			listifcEngines.add((IfcEngine)session.get(StorePackage.eINSTANCE.getIfcEngine(), oid, false));
		}
		List<Plugin> listplugins = result.getPlugins();
		for (long oid : input.getPlugins()) {
			listplugins.add((Plugin)session.get(StorePackage.eINSTANCE.getPlugin(), oid, false));
		}
		List<Deserializer> listdeserializers = result.getDeserializers();
		for (long oid : input.getDeserializers()) {
			listdeserializers.add((Deserializer)session.get(StorePackage.eINSTANCE.getDeserializer(), oid, false));
		}
		return result;
	}

	public Set<SSerializer> convertToSSetSerializer(Collection<Serializer> input) {
		Set<SSerializer> result = new HashSet<SSerializer>();
		for (Serializer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Serializer> convertFromSSetSerializer(Collection<SSerializer> input, BimDatabaseSession session) {
		Set<Serializer> result = new HashSet<Serializer>();
		for (SSerializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SSerializer> convertToSListSerializer(Collection<Serializer> input) {
		List<SSerializer> result = new ArrayList<SSerializer>();
		for (Serializer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Serializer> convertFromSListSerializer(Collection<SSerializer> input, BimDatabaseSession session) {
		List<Serializer> result = new ArrayList<Serializer>();
		for (SSerializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SSerializer convertToSObject(Serializer input) {
		if (input == null) {
			return null;
		}
		SSerializer result = new SSerializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setExtension(input.getExtension());
		result.setContentType(input.getContentType());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultSerializer(input.isDefaultSerializer());
		GuidanceProvider guidanceProviderVal = input.getGuidanceProvider();
		result.setGuidanceProviderId(guidanceProviderVal == null ? -1 : guidanceProviderVal.getOid());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Serializer convertFromSObject(SSerializer input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Serializer result = StoreFactory.eINSTANCE.createSerializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setExtension(input.getExtension());
		result.setContentType(input.getContentType());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultSerializer(input.isDefaultSerializer());
		result.setGuidanceProvider((GuidanceProvider)session.get(StorePackage.eINSTANCE.getGuidanceProvider(), input.getGuidanceProviderId(), false));
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false));
		return result;
	}

	public Set<SGuidanceProvider> convertToSSetGuidanceProvider(Collection<GuidanceProvider> input) {
		Set<SGuidanceProvider> result = new HashSet<SGuidanceProvider>();
		for (GuidanceProvider o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<GuidanceProvider> convertFromSSetGuidanceProvider(Collection<SGuidanceProvider> input, BimDatabaseSession session) {
		Set<GuidanceProvider> result = new HashSet<GuidanceProvider>();
		for (SGuidanceProvider o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SGuidanceProvider> convertToSListGuidanceProvider(Collection<GuidanceProvider> input) {
		List<SGuidanceProvider> result = new ArrayList<SGuidanceProvider>();
		for (GuidanceProvider o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<GuidanceProvider> convertFromSListGuidanceProvider(Collection<SGuidanceProvider> input, BimDatabaseSession session) {
		List<GuidanceProvider> result = new ArrayList<GuidanceProvider>();
		for (SGuidanceProvider o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SGuidanceProvider convertToSObject(GuidanceProvider input) {
		if (input == null) {
			return null;
		}
		SGuidanceProvider result = new SGuidanceProvider();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setClassName(input.getClassName());
		List<Long> listserializers = new ArrayList<Long>();
		for (Serializer v : input.getSerializers()) {
			listserializers.add(v.getOid());
		}
		result.setSerializers(listserializers);
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public GuidanceProvider convertFromSObject(SGuidanceProvider input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		GuidanceProvider result = StoreFactory.eINSTANCE.createGuidanceProvider();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setClassName(input.getClassName());
		List<Serializer> listserializers = result.getSerializers();
		for (long oid : input.getSerializers()) {
			listserializers.add((Serializer)session.get(StorePackage.eINSTANCE.getSerializer(), oid, false));
		}
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false));
		return result;
	}

	public Set<SIfcEngine> convertToSSetIfcEngine(Collection<IfcEngine> input) {
		Set<SIfcEngine> result = new HashSet<SIfcEngine>();
		for (IfcEngine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<IfcEngine> convertFromSSetIfcEngine(Collection<SIfcEngine> input, BimDatabaseSession session) {
		Set<IfcEngine> result = new HashSet<IfcEngine>();
		for (SIfcEngine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SIfcEngine> convertToSListIfcEngine(Collection<IfcEngine> input) {
		List<SIfcEngine> result = new ArrayList<SIfcEngine>();
		for (IfcEngine o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<IfcEngine> convertFromSListIfcEngine(Collection<SIfcEngine> input, BimDatabaseSession session) {
		List<IfcEngine> result = new ArrayList<IfcEngine>();
		for (SIfcEngine o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SIfcEngine convertToSObject(IfcEngine input) {
		if (input == null) {
			return null;
		}
		SIfcEngine result = new SIfcEngine();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setActive(input.isActive());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public IfcEngine convertFromSObject(SIfcEngine input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		IfcEngine result = StoreFactory.eINSTANCE.createIfcEngine();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setActive(input.isActive());
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false));
		return result;
	}

	public Set<SPlugin> convertToSSetPlugin(Collection<Plugin> input) {
		Set<SPlugin> result = new HashSet<SPlugin>();
		for (Plugin o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Plugin> convertFromSSetPlugin(Collection<SPlugin> input, BimDatabaseSession session) {
		Set<Plugin> result = new HashSet<Plugin>();
		for (SPlugin o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SPlugin> convertToSListPlugin(Collection<Plugin> input) {
		List<SPlugin> result = new ArrayList<SPlugin>();
		for (Plugin o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Plugin> convertFromSListPlugin(Collection<SPlugin> input, BimDatabaseSession session) {
		List<Plugin> result = new ArrayList<Plugin>();
		for (SPlugin o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SPlugin convertToSObject(Plugin input) {
		if (input == null) {
			return null;
		}
		SPlugin result = new SPlugin();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.isEnabled());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Plugin convertFromSObject(SPlugin input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Plugin result = StoreFactory.eINSTANCE.createPlugin();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setEnabled(input.isEnabled());
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false));
		return result;
	}

	public Set<SDeserializer> convertToSSetDeserializer(Collection<Deserializer> input) {
		Set<SDeserializer> result = new HashSet<SDeserializer>();
		for (Deserializer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public Set<Deserializer> convertFromSSetDeserializer(Collection<SDeserializer> input, BimDatabaseSession session) {
		Set<Deserializer> result = new HashSet<Deserializer>();
		for (SDeserializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public List<SDeserializer> convertToSListDeserializer(Collection<Deserializer> input) {
		List<SDeserializer> result = new ArrayList<SDeserializer>();
		for (Deserializer o : input) {
			result.add(convertToSObject(o));
		}
		return result;
	}

	public List<Deserializer> convertFromSListDeserializer(Collection<SDeserializer> input, BimDatabaseSession session) {
		List<Deserializer> result = new ArrayList<Deserializer>();
		for (SDeserializer o : input) {
			result.add(convertFromSObject(o, session));
		}
		return result;
	}

	public SDeserializer convertToSObject(Deserializer input) {
		if (input == null) {
			return null;
		}
		SDeserializer result = new SDeserializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultDeserializer(input.isDefaultDeserializer());
		Settings settingsVal = input.getSettings();
		result.setSettingsId(settingsVal == null ? -1 : settingsVal.getOid());
		return result;
	}

	public Deserializer convertFromSObject(SDeserializer input, BimDatabaseSession session) {
		if (input == null) {
			return null;
		}
		Deserializer result = StoreFactory.eINSTANCE.createDeserializer();
		result.setOid(input.getOid());
		result.setName(input.getName());
		result.setDescription(input.getDescription());
		result.setClassName(input.getClassName());
		result.setEnabled(input.isEnabled());
		result.setDefaultDeserializer(input.isDefaultDeserializer());
		result.setSettings((Settings)session.get(StorePackage.eINSTANCE.getSettings(), input.getSettingsId(), false));
		return result;
	}
		public SUserType convertToSObject(UserType input) {
			return SUserType.values()[input.ordinal()];
		}
		
		public UserType convertFromSObject(SUserType input) {
			return UserType.values()[input.ordinal()];
		}
		public SCheckinState convertToSObject(CheckinState input) {
			return SCheckinState.values()[input.ordinal()];
		}
		
		public CheckinState convertFromSObject(SCheckinState input) {
			return CheckinState.values()[input.ordinal()];
		}
		public SSIPrefix convertToSObject(SIPrefix input) {
			return SSIPrefix.values()[input.ordinal()];
		}
		
		public SIPrefix convertFromSObject(SSIPrefix input) {
			return SIPrefix.values()[input.ordinal()];
		}
		public SObjectState convertToSObject(ObjectState input) {
			return SObjectState.values()[input.ordinal()];
		}
		
		public ObjectState convertFromSObject(SObjectState input) {
			return ObjectState.values()[input.ordinal()];
		}
		public SMergeIdentifier convertToSObject(MergeIdentifier input) {
			return SMergeIdentifier.values()[input.ordinal()];
		}
		
		public MergeIdentifier convertFromSObject(SMergeIdentifier input) {
			return MergeIdentifier.values()[input.ordinal()];
		}
}