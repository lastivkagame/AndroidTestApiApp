using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Web.Store.Repositories
{
    public interface IRepository<T> : IDisposable where T : class
    {
        IEnumerable<T> GetAll();
        Task<T> GetAsync(int id);
        Task CreateAsync(T item);
        void Update(T item);
        Task DeleteAsync(int id);
        Task SaveAsync();
    }
}
